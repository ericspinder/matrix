package dev.inward.matrix.Agent;

import dev.inward.matrix.rubric.Roller;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LocalSystemNetworking {

    private ReentrantReadWriteLock gate = new ReentrantReadWriteLock();
    Map<InterfaceAddress, NetworkInterface> externalInterfaces = new HashMap<>();
    Map<InterfaceAddress, NetworkInterface> loopbackInterfaces = new HashMap<>();
    Map<InterfaceAddress, NetworkInterface> tunnelInterfaces = new HashMap<>();

    public final Map<InterfaceAddress, NetworkInterface> getExternalInterfaces() {
        try {
            gate.readLock().lock();
            return this.externalInterfaces;
        } finally {
            gate.readLock().unlock();
        }
    }

    public final Map<InterfaceAddress, NetworkInterface> getLoopbackInterfaces() {
        try {
            gate.readLock().lock();
            return this.loopbackInterfaces;
        } finally {
            gate.readLock().unlock();
        }
    }

    public final Map<InterfaceAddress, NetworkInterface> getTunnelInterfaces() {
        try {
            gate.readLock().lock();
            return this.tunnelInterfaces;
        } finally {
            gate.readLock().unlock();
        }
    }

    public final void refreshPlatformInterfaceAddresses() throws Roller {
        try {
            gate.writeLock().lock();
            enrollPlatformInterfaceAddresses();
        } finally {
            gate.writeLock().unlock();
        }
        ;
    }

    private final void enrollPlatformInterfaceAddresses() throws Roller {
        try {
            System.out.println(" Network Interfaces:");
            Enumeration<NetworkInterface> allInterfaces = NetworkInterface.getNetworkInterfaces();
            int networkInterfaceInt = 0;
            while (allInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = allInterfaces.nextElement();
                System.out.println("************************");
                System.out.println("Network Interface - " + networkInterfaceInt++);
                if (networkInterface.isUp()) {
                    this.parseInetAddresses(1, networkInterface);
                } else {
                    System.out.println(networkInterface.getDisplayName() + " is not up ");
                }
            }
            System.out.println("************************");
        } catch (SocketException se) {
            System.out.println(se.getMessage());
        }
        return;
    }

    private final void parseInetAddresses(int layer, NetworkInterface networkInterface) throws SocketException {
        if (layer > 10) throw new RuntimeException("must be some sort of loop in the subinterfaces");
        if (networkInterface.getParent() != null) {
            System.out.println("SubInterface for " + networkInterface.getParent().getDisplayName());
        }
        System.out.println("      name: " + networkInterface.getName());
        System.out.println("      displayName: " + networkInterface.getDisplayName());
        System.out.println("      is point-to-point? " + networkInterface.isPointToPoint());
        System.out.println("      is virtual? " + networkInterface.isVirtual());
        System.out.println("      supports multicast? " + networkInterface.supportsMulticast());
        System.out.println("      is loopback? " + networkInterface.isLoopback());
        System.out.println("");
        Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
        int ipAddressEnumeration = 0;
        while (inetAddressEnumeration.hasMoreElements()) {
            System.out.println("     ----------------------------------------");
            System.out.println("  IP Address Enumeration  - " + ipAddressEnumeration++);
            InetAddress inetAddress = inetAddressEnumeration.nextElement();
            System.out.println("     Canonical Host Name: " + inetAddress.getCanonicalHostName());
            System.out.println("     Host Address: " + inetAddress.getHostAddress());
            System.out.println("     Host Name: " + inetAddress.getHostName());
            System.out.println("    -----------------------------------------");
        }
        int networkInterfaceList = 0;
        for (InterfaceAddress ifAddress : networkInterface.getInterfaceAddresses()) {
            System.out.println("  Network Interface Address - " + networkInterfaceList++);
            InetAddress address = ifAddress.getAddress();
            System.out.println("     Address: " + address);
            InetAddress broadcast = ifAddress.getBroadcast();
            System.out.println("     Broadcast: " + broadcast);
            if (networkInterface.isLoopback()) {
                this.loopbackInterfaces.put(ifAddress, networkInterface);
            } else {
                if (networkInterface.isPointToPoint()) {
                    this.tunnelInterfaces.put(ifAddress, networkInterface);
                } else {
                    this.externalInterfaces.put(ifAddress, networkInterface);
                }
            }
        }
        Enumeration<NetworkInterface> subInterfacesEnumeration = networkInterface.getSubInterfaces();
        if (subInterfacesEnumeration != null && subInterfacesEnumeration.hasMoreElements()) {
            int subinterfacesCount = 0;
            while (subInterfacesEnumeration.hasMoreElements()) {
                System.out.println("   ----------------------------------");
                System.out.println("   subinterface - " + subinterfacesCount++);
                this.parseInetAddresses(layer + 1, subInterfacesEnumeration.nextElement());
            }
            System.out.println("   ------------------------------------");
        }
    }

    public LocalSystemNetworking() {
    }
}
