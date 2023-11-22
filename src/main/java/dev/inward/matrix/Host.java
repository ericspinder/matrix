package dev.inward.matrix;

import dev.inward.matrix.fact.threshold.SocketAddress;

import java.nio.channels.*;
import java.util.concurrent.locks.StampedLock;

public abstract class Host<H extends Host<H>> implements Comparable<H> {

    private final StampedLock gate = new StampedLock();
    private AsynchronousChannelGroup networkGroup;
    protected final SocketAddress.Local localSocket;

    public Host(AsynchronousChannelGroup networkGroup, SocketAddress.Local socket) {
        this.networkGroup = networkGroup;
        this.localSocket = socket;
    }
    public static class Remote extends Host<Remote> {

        protected final SocketAddress.Remote remoteSocket;

        public Remote(final AsynchronousChannelGroup networkGroup, final SocketAddress.Local localSocket, final SocketAddress.Remote remoteSocket) {
            super(networkGroup,localSocket);
            this.remoteSocket = remoteSocket;
        }

        public SocketAddress.Remote getRemoteSocket() {
            return remoteSocket;
        }

        @Override
        public int compareTo(Remote that) {
            int isZero = this.localSocket.compareTo(that.localSocket);
            if (isZero == 0) {
                return this.remoteSocket.compareTo(that.remoteSocket);
            }
            return isZero;
        }
    }
    public static class Principal extends Host<Principal> {

        public Principal(final AsynchronousChannelGroup networkGroup, final SocketAddress.Local localSocket) {
            super(networkGroup,localSocket);
        }

        @Override
        public int compareTo(Principal that) {
            return this.localSocket.compareTo(that.localSocket);
        }
    }

    public final void setNetworkGroup(final AsynchronousChannelGroup networkGroup) {
        long writeLock = gate.writeLock();
        try {
            this.networkGroup = networkGroup;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }
    public final AsynchronousChannelGroup getNetworkGroup() {
        long readLock = gate.readLock();
        try {
            return networkGroup;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }
}
