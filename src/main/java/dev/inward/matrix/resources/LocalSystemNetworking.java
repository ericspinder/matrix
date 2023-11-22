package dev.inward.matrix.resources;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.report.DefaultFailure;
import dev.inward.matrix.fact.threshold.SocketAddress;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

public class LocalSystemNetworking {
    
    private static volatile LocalSystemNetworking INSTANCE;

    public static LocalSystemNetworking getInstance() {
        if (INSTANCE == null) {
            LocalSystemNetworking newInstance = new LocalSystemNetworking();
            try {
                newInstance.enrollPlatformInterfaceAddresses();
            }
            catch (SocketException se) {
                throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return, newInstance.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,se);
            }
            INSTANCE = newInstance;
        }
        return INSTANCE;
    }

    Map<NetworkMapping,Instant> externalActiveInterfaces = new ConcurrentHashMap<>();
    Map<NetworkMapping,Instant> loopbackActiveInterfaces = new ConcurrentHashMap<>();
    Map<NetworkMapping,Instant> inactiveInterfaces = new ConcurrentHashMap<>();

    public static final class NetworkMapping implements Comparable<NetworkMapping> {

        protected final InterfaceAddress interfaceAddress;
        protected final BigInteger bytes;
        protected final NetworkInterface networkInterface;

        public NetworkMapping(final InterfaceAddress interfaceAddress, final NetworkInterface networkInterface) {
            this.interfaceAddress = interfaceAddress;
            this.networkInterface = networkInterface;
            this.bytes = new BigInteger(1,interfaceAddress.getAddress().getAddress());
        }
        public final BigInteger getBytes() {
            return this.bytes;
        }

        public InterfaceAddress getInterfaceAddress() {
            return interfaceAddress;
        }

        public NetworkInterface getNetworkInterface() {
            return networkInterface;
        }

        @Override
        public int compareTo(NetworkMapping that) {
            return this.bytes.compareTo(that.bytes);
        }
    }

    public final Map<NetworkMapping,Instant> getExternalActiveInterfaces() {
        return this.externalActiveInterfaces;
    }

    public final Map<NetworkMapping,Instant> getLoopbackActiveInterfaces() {
        return this.loopbackActiveInterfaces;
    }

    public final Map<NetworkMapping,Instant> getInactiveInterfaces() {
        return this.inactiveInterfaces;
    }

    public final void refresh() {
        try {
            enrollPlatformInterfaceAddresses();
        }
        catch (SocketException se) {
            throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return, this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional, se);
        }
    }

    private final void enrollPlatformInterfaceAddresses() throws SocketException {
            Enumeration<NetworkInterface> allInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = allInterfaces.nextElement();
                if (networkInterface.isUp()) {
                    this.parseInetAddresses(1, networkInterface);
                }
            }
    }

    private final void parseInetAddresses(int layer, NetworkInterface networkInterface) throws SocketException {
        if (layer > 3) {
            throw new MatrixException(MatrixException.Type.Recursion,this.getClass(), Indicia.Focus.Assembly, Indicia.Severity.Unexpected, new Exception("Layer: " + layer));
        }
        for (InterfaceAddress ifAddress : networkInterface.getInterfaceAddresses()) {
            if (networkInterface.isLoopback()) {
                if (ifAddress.getBroadcast() != null) {
                    this.loopbackActiveInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                } else {
                    this.inactiveInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                }
            } else {
                if (ifAddress.getBroadcast() != null) {
                    this.externalActiveInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                } else {
                    this.inactiveInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                }
            }
        }
        Enumeration<java.net.NetworkInterface> subInterfacesEnumeration = networkInterface.getSubInterfaces();
        if (subInterfacesEnumeration != null && subInterfacesEnumeration.hasMoreElements()) {
            while (subInterfacesEnumeration.hasMoreElements()) {
                this.parseInetAddresses(layer + 1, subInterfacesEnumeration.nextElement());
            }
        }
    }
    private OS parseOS() {
        String osName = System.getProperty("os.name");
        if (osName == null) {
            throw new MatrixException(MatrixException.Type.UnableToParseOS, this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Unexpected,null);
        }
        osName = osName.toLowerCase(Locale.ENGLISH);
        if (osName.contains("windows")) {
            return OS.WINDOWS;
        } else if (osName.contains("linux")
                || osName.contains("mpe/ix")
                || osName.contains("freebsd")
                || osName.contains("irix")
                || osName.contains("digital unix")
                || osName.contains("unix")) {
            return OS.UNIX;
        } else if (osName.contains("mac os")) {
            return OS.MAC;
        } else if (osName.contains("sun os")
                || osName.contains("sunos")
                || osName.contains("solaris")) {
            return OS.POSIX_UNIX;
        } else if (osName.contains("hp-ux")
                || osName.contains("aix")) {
            return OS.POSIX_UNIX;
        } else {
            return OS.OTHER;
        }
    }

    public enum OS {
        WINDOWS,
        UNIX,
        POSIX_UNIX,
        MAC,
        OTHER;
    }
    protected final OS os;

    private LocalSystemNetworking() {
        this.os = this.parseOS();
    }
    public final OS getOs() {
        return this.os;
    }
}
