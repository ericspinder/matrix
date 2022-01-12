package dev.inward.matrix.id.platform;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Map;

public class Platform extends Id<Platform> {

    private final Map<InterfaceAddress, NetworkInterface> activeExternalAddresses;

    private final Map<InterfaceAddress, NetworkInterface> activeLoopbackAddresses;

    public Platform(Map<InterfaceAddress, NetworkInterface> activeExternalAddresses, Map<InterfaceAddress, NetworkInterface> activeLoopbackAddresses) {
        this.activeExternalAddresses = activeExternalAddresses;
        this.activeLoopbackAddresses = activeLoopbackAddresses;
    }

    public Map<InterfaceAddress, NetworkInterface> getActiveLoopbackAddresses() {
        return activeLoopbackAddresses;
    }

    public Map<InterfaceAddress, NetworkInterface> getActiveExternalAddresses() {
        return activeExternalAddresses;
    }
}
