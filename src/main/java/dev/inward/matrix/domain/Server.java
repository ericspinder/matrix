package dev.inward.matrix.domain;

import java.net.InetAddress;

public class Server {

    protected final String name;
    protected final InetAddress ipAddress;

    public Server(String name, InetAddress ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return this.name;
    }

    public InetAddress getIpAddress() {
        return this.ipAddress;
    }

}
