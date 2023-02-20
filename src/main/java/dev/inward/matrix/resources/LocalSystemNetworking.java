package dev.inward.matrix.resources;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.report.DefaultFailure;
import dev.inward.matrix.fact.threshold.Threshold;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.util.*;
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
                throw new NotionStartupException(NotionStartupException.Type.NetworkUnavailable_No_Return, newInstance.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,se);
            }
            INSTANCE = newInstance;
        }
        return INSTANCE;
    }
    private Instant updateInstant;
    private StampedLock gate = new StampedLock();

    List<Threshold> externalActiveInterfaces = new ArrayList<>();
    List<Threshold> loopbackActiveInterfaces = new ArrayList<>();
    List<Threshold> inactiveInterfaces = new ArrayList<>();

    public final List<Threshold> getExternalActiveInterfaces() {
        long readLock = gate.readLock();
        try {
            return this.externalActiveInterfaces;
        } finally {
            gate.unlockRead(readLock);
        }
    }

    public final List<Threshold> getLoopbackActiveInterfaces() {
        long readLock = gate.readLock();
        try {
            return this.loopbackActiveInterfaces;
        } finally {
            gate.unlockRead(readLock);
        }
    }

    public final List<Threshold> getInactiveInterfaces() {
        long readLock = gate.readLock();
        try {
            return this.inactiveInterfaces;
        } finally {
            gate.unlockRead(readLock);
        }
    }

    public final void refresh() {
        long writeLock = gate.writeLock();
        try {
            enrollPlatformInterfaceAddresses();
        }
        catch (SocketException se) {
            throw new NotionStartupException(NotionStartupException.Type.NetworkUnavailable_No_Return, this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional, se);
        }
        finally {
            gate.unlockWrite(writeLock);
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
            this.updateInstant = Instant.now();
    }

    private final void parseInetAddresses(int layer, NetworkInterface networkInterface) throws SocketException {
        if (layer > 3) {
            Map<String, Object> details = new HashMap<>();
            details.put("error","recursion");
            details.put("networkInterface.getName()", networkInterface.getName());
            DefaultFailure defaultFailure = new DefaultFailure(Identity.Ego.Aforementioned,Instant.now(),"", InternetClass.Aforementioned, details);
        }
        Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
        while (inetAddressEnumeration.hasMoreElements()) {
            InetAddress inetAddress = inetAddressEnumeration.nextElement();
        }
        for (InterfaceAddress ifAddress : networkInterface.getInterfaceAddresses()) {
            if (networkInterface.isLoopback()) {
                if (ifAddress.getBroadcast() != null) {
                    this.loopbackActiveInterfaces.add(new Threshold(new Identity.Ego(Governance.Ethereal.Aforementioned),ifAddress,networkInterface));
                } else {
                    this.inactiveInterfaces.add(new Threshold(new Identity.Ego(Governance.Ethereal.Aforementioned),ifAddress, networkInterface));
                }
            } else {
                if (ifAddress.getBroadcast() != null) {
                    this.externalActiveInterfaces.add(new Threshold(new Identity.Ego(Governance.Ethereal.Aforementioned),ifAddress, networkInterface));
                } else {
                    this.inactiveInterfaces.add(new Threshold(new Identity.Ego(Governance.Ethereal.Aforementioned),ifAddress, networkInterface));
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
            throw new NotionStartupException(NotionStartupException.Type.UnableToParseOS, this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Unexpected,null);
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
