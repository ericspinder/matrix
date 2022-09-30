package dev.inward.matrix.domain;

import com.google.common.net.InetAddresses;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.net.InetAddress;

public class Server extends Identity<Server, Context.Ethereal> {

    protected final InetAddress ipV4Address;
    protected final InetAddress ipV6Address;

    public Server(String name, Context.Ethereal ethereal, String ipV4Address, String ipV6Address) {
        super(name, ethereal);
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
