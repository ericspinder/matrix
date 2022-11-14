package dev.inward.matrix.resources;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.fact.matter.Indicia;
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
        if (layer > 3) throw new NotionStartupException(NotionStartupException.Type.Recursion,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Unexpected,null);
        Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
        while (inetAddressEnumeration.hasMoreElements()) {
            InetAddress inetAddress = inetAddressEnumeration.nextElement();
        }
        for (InterfaceAddress ifAddress : networkInterface.getInterfaceAddresses()) {
            if (networkInterface.isLoopback()) {
                if (ifAddress.getBroadcast() != null) {
                    this.loopbackActiveInterfaces.put(new Threshold(networkInterface,ifAddress),);
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
        Enumeration<java.net.NetworkInterface> subInterfacesEnumeration = networkInterface.getSubInterfaces();
        if (subInterfacesEnumeration != null && subInterfacesEnumeration.hasMoreElements()) {
            while (subInterfacesEnumeration.hasMoreElements()) {
                this.parseInetAddresses(layer + 1, subInterfacesEnumeration.nextElement());
            }
        }
    }

    private LocalSystemNetworking() {}
}
