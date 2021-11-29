package dev.inward.matrix;

import dev.inward.matrix.id.platform.Platform;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Map;

public class Inward {

    public static void main(String... args) {

        System.out.println("Starting");
        Platform platform = new Platform(LocalSystemNetworking.INSTANCE.getExternalActiveInterfaces(), LocalSystemNetworking.INSTANCE.getLoopbackActiveInterfaces());
        for (Map.Entry<InterfaceAddress, NetworkInterface> entry : platform.getActiveExternalAddresses().entrySet()) {
            System.out.println("external - address: " + entry.getKey().getAddress().getHostAddress() + ", broadcast: " + entry.getKey().getBroadcast().getHostAddress() + ", prefix: " + entry.getKey().getNetworkPrefixLength() + ", interface: " + entry.getValue().getName() + ", display name: " + entry.getValue().getDisplayName());
        }
        for (Map.Entry<InterfaceAddress, NetworkInterface> entry : platform.getActiveLoopbackAddresses().entrySet()) {
            System.out.println("loopback - address: " + entry.getKey().getAddress().getHostAddress() + ", broadcast: " + entry.getKey().getBroadcast().getHostAddress() + ", prefix: " + entry.getKey().getNetworkPrefixLength() + ", interface: " + entry.getValue().getName() + ", display name: " + entry.getValue().getDisplayName());
        }


        System.exit(0);
    }


}
