package dev.inward.matrix.domain;

import com.google.common.net.InetAddresses;

import java.net.InetAddress;

public class Server {

    protected final String name;
    protected final InetAddress ipV4Address;
    protected final InetAddress ipV6Address;

    public Server(String name, String ipV4Address, String ipV6Address) {
        this.name = name;
        this.ipV4Address = InetAddresses.forString(ipV4Address);
        this.ipV6Address = InetAddresses.forString(ipV6Address);
    }

    public String getName() {
        return this.name;
    }

    public InetAddress getIpV4Address() {
        return ipV4Address;
    }

    public InetAddress getIpV6Address() {
        return ipV6Address;
    }
}
