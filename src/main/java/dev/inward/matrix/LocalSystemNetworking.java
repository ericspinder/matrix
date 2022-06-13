package dev.inward.matrix;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.matter.Subject;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
                throw new NotionStartupException(NotionStartupException.Type.NetworkUnavailable_No_Return, newInstance.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,se);
            }
            INSTANCE = newInstance;
        }
        return INSTANCE;
    }
    private Instant updateInstant;
    private StampedLock gate = new StampedLock();

    Map<InterfaceAddress, NetworkInterface> externalActiveInterfaces = new HashMap<>();
    Map<InterfaceAddress, NetworkInterface> loopbackActiveInterfaces = new HashMap<>();
    Map<InterfaceAddress, NetworkInterface> inactiveInterfaces = new HashMap<>();

    public final Map<InterfaceAddress, NetworkInterface> getExternalActiveInterfaces() {
        long readLock = gate.readLock();
        try {
            return this.externalActiveInterfaces;
        } finally {
            gate.unlockRead(readLock);
        }
    }

    public final Map<InterfaceAddress, NetworkInterface> getLoopbackActiveInterfaces() {
        long readLock = gate.readLock();
        try {
            return this.loopbackActiveInterfaces;
        } finally {
            gate.unlockRead(readLock);
        }
    }

    public final Map<InterfaceAddress, NetworkInterface> getInactiveInterfaces() {
        long readLock = gate.readLock();
        try {
            return this.inactiveInterfaces;
        } finally {
            gate.unlockRead(readLock);
        }
    }

    public final void refreshPlatformInterfaceAddresses() {
        long writeLock = gate.writeLock();
        try {
            enrollPlatformInterfaceAddresses();
        }
        catch (SocketException se) {
            throw new NotionStartupException(NotionStartupException.Type.NetworkUnavailable_No_Return, this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional, se);
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
        if (layer > 10) throw new NotionStartupException(NotionStartupException.Type.Recursion,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Unexpected,null);
        Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
        while (inetAddressEnumeration.hasMoreElements()) {
            InetAddress inetAddress = inetAddressEnumeration.nextElement();
        }
        for (InterfaceAddress ifAddress : networkInterface.getInterfaceAddresses()) {
            if (networkInterface.isLoopback()) {
                if (ifAddress.getBroadcast() != null) {
                    this.loopbackActiveInterfaces.put(ifAddress, networkInterface);
                } else {
                    this.inactiveInterfaces.put(ifAddress, networkInterface);
                }
            } else {
                if (ifAddress.getBroadcast() != null) {
                    this.externalActiveInterfaces.put(ifAddress, networkInterface);
                } else {
                    this.inactiveInterfaces.put(ifAddress, networkInterface);
                }
            }
        }
        Enumeration<NetworkInterface> subInterfacesEnumeration = networkInterface.getSubInterfaces();
        if (subInterfacesEnumeration != null && subInterfacesEnumeration.hasMoreElements()) {
            while (subInterfacesEnumeration.hasMoreElements()) {
                this.parseInetAddresses(layer + 1, subInterfacesEnumeration.nextElement());
            }
        }
    }

    private LocalSystemNetworking() {}
}
