/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import org.bouncycastle.util.IPAddress;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalSystemNetworking {
    
    private static volatile LocalSystemNetworking INSTANCE;

    public static LocalSystemNetworking getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalSystemNetworking.class) {
                if (INSTANCE != null) {
                    return INSTANCE;
                }
                LocalSystemNetworking newInstance = new LocalSystemNetworking();
                try {
                    newInstance.enrollPlatformInterfaceAddresses();
                } catch (SocketException se) {
                    throw new RuntimeException("Socket Exception getting local IP addresses");
                    //throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return,"Local System Networking", IndiciaKey.Focus.Admonitory, Matter.Severity.Exceptional,se);
                }
                INSTANCE = newInstance;
            }
        }
        return INSTANCE;
    }

    Map<NetworkMapping,Instant> activeExternalInterfaces = new ConcurrentHashMap<>();
    Map<NetworkMapping,Instant> activeLoopBackInterfaces = new ConcurrentHashMap<>();
    Map<NetworkMapping,Instant> activeBroadcastInterfaces = new ConcurrentHashMap<>();

    public static final class NetworkMapping implements Comparable<NetworkMapping> {

        private final InterfaceAddress interfaceAddress;
        private final BigInteger bytes;
        private final IPAddress ipAddress;
        private final InetAddress inetAddress;
        private final NetworkInterface sourceNetworkInterface;

        public NetworkMapping(final InterfaceAddress interfaceAddress, final NetworkInterface sourceNetworkInterface) {
            this.interfaceAddress = interfaceAddress;
            this.sourceNetworkInterface = sourceNetworkInterface;
            this.bytes = new BigInteger(1,interfaceAddress.getAddress().getAddress());
            this.ipAddress = new IPAddress();
        }
        public BigInteger getBytes() {
            return this.bytes;
        }

        public InterfaceAddress getInterfaceAddress() {
            return interfaceAddress;
        }

        public NetworkInterface getSourceNetworkInterface() {
            return sourceNetworkInterface;
        }

        @Override
        public int compareTo(NetworkMapping that) {
            return this.bytes.compareTo(that.bytes);
        }
    }

    public final Map<NetworkMapping,Instant> getActiveExternalInterfaces() {
        return this.activeExternalInterfaces;
    }

    public final Map<NetworkMapping,Instant> getActiveLoopBackInterfaces() {
        return this.activeLoopBackInterfaces;
    }

    public final Map<NetworkMapping,Instant> getActiveBroadcastInterfaces() {
        return this.activeBroadcastInterfaces;
    }

    public final void refresh() {
        try {
            enrollPlatformInterfaceAddresses();
        }
        catch (SocketException se) {
            throw new RuntimeException("Problem enrolling platform Interfaces addresses", se);
            //throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return, this.getClass(), IndiciaKey.Focus.Admonitory, Matter.Severity.Exceptional, se);
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
        if (layer > 20) {
            System.err.println("Looks like recursion error on network interface = " + networkInterface.getDisplayName());
            return;
            //throw new MatrixException(MatrixException.Type.Recursion,"Local Systems Networking", IndiciaKey.Focus.Assembly, Matter.Severity.Unexpected, new Exception("Layer: " + layer));
        }
        for (InterfaceAddress ifAddress : networkInterface.getInterfaceAddresses()) {
            if (networkInterface.isLoopback()) {
                if (ifAddress.getBroadcast() != null) {
                    this.activeLoopBackInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                } else {
                    this.activeBroadcastInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                }
            } else {
                if (ifAddress.getBroadcast() != null) {
                    this.activeExternalInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                } else {
                    this.activeBroadcastInterfaces.put(new NetworkMapping(ifAddress,networkInterface),Instant.now());
                }
            }
        }
        Enumeration<java.net.NetworkInterface> subInterfacesEnumeration = networkInterface.getSubInterfaces();
        if (subInterfacesEnumeration.hasMoreElements()) {
            while (subInterfacesEnumeration.hasMoreElements()) {
                this.parseInetAddresses(layer + 1, subInterfacesEnumeration.nextElement());
            }
        }
    }
    private OS parseOS() {
        String osName = System.getProperty("os.name");
        if (osName == null) {
            osName = "other";
            //throw new MatrixException(MatrixException.Type.UnableToParseOS, "Local Systems Networking", IndiciaKey.Focus.Admonitory, Matter.Severity.Unexpected, new Exception("\"os.name\" system property not found"));
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
        OTHER
    }
    protected final OS os;

    private LocalSystemNetworking() {
        this.os = this.parseOS();
    }
    public final OS getOs() {
        return this.os;
    }
}
