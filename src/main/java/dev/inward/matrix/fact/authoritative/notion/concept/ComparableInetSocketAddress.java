package dev.inward.matrix.fact.authoritative.notion.concept;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ComparableInetSocketAddress extends InetSocketAddress implements Comparable<ComparableInetSocketAddress> {


    public ComparableInetSocketAddress(int port) {
        super(port);
    }

    public ComparableInetSocketAddress(InetAddress addr, int port) {
        super(addr, port);
    }

    public ComparableInetSocketAddress(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public int compareTo(ComparableInetSocketAddress o) {
        int isZero = this.getAddress().;
    }
}
