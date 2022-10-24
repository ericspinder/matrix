package dev.inward.matrix.domain;

import com.google.common.net.InetAddresses;

import java.net.InetAddress;

public class Server {

    protected final Domain domain;
    protected final InetAddress inetAddress;

    public Server(Domain domain, InetAddress inetAddress) {
        this.domain = domain;
        this.inetAddress = inetAddress;
    }

    public Domain getDomain() {
        return domain;
    }
    public InetAddress getInetAddress() {
        return this.inetAddress;
    }
}
