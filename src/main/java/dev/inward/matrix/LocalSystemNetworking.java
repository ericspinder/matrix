package dev.inward.matrix;


import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LocalSystemNetworking {
    
    public static final LocalSystemNetworking INSTANCE = new LocalSystemNetworking();

    private ReentrantReadWriteLock gate = new ReentrantReadWriteLock();

    Map<InterfaceAddress, NetworkInterface> externalActiveInterfaces = new HashMap<>();
    Map<InterfaceAddress, NetworkInterface> loopbackActiveInterfaces = new HashMap<>();
    Map<InterfaceAddress, NetworkInterface> inactiveInterfaces = new HashMap<>();

    public final Map<InterfaceAddress, NetworkInterface> getExternalActiveInterfaces() {
        try {
            gate.readLock().lock();
            return this.externalActiveInterfaces;
        } finally {
            gate.readLock().unlock();
        }
    }

    public final Map<InterfaceAddress, NetworkInterface> getLoopbackActiveInterfaces() {
        try {
            gate.readLock().lock();
            return this.loopbackActiveInterfaces;
        } finally {
            gate.readLock().unlock();
        }
    }

    public final Map<InterfaceAddress, NetworkInterface> getInactiveInterfaces() {
        try {
            gate.readLock().lock();
            return this.inactiveInterfaces;
        } finally {
            gate.readLock().unlock();
        }
    }

    public final void refreshPlatformInterfaceAddresses() {
        try {
            gate.writeLock().lock();
            enrollPlatformInterfaceAddresses();
        } finally {
            gate.writeLock().unlock();
        }
    }

    private final void enrollPlatformInterfaceAddresses() {
        try {
            Enumeration<NetworkInterface> allInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = allInterfaces.nextElement();
                if (networkInterface.isUp()) {
                    this.parseInetAddresses(1, networkInterface);
                }
            }
        } catch (SocketException se) {
            System.out.println(se.getMessage());
        }
        return;
    }

    private final void parseInetAddresses(int layer, NetworkInterface networkInterface) throws SocketException {
        if (layer > 10) throw new RuntimeException("must be some sort of loop in the subinterfaces");
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

    private LocalSystemNetworking() {
        try {
            gate.writeLock().lock();
            this.enrollPlatformInterfaceAddresses();
        } finally {
            gate.writeLock().unlock();
        }
    }
}
