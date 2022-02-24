package com.notionds.dataSupplier.library;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;

import java.net.InetAddress;

public final class RemoteServer extends Fact<RemoteServer, RemoteServer.RemoteOperational, RemoteServer.Transport,Id.Ego> {

    private InetAddress ipAddress;

    public RemoteServer (InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public InetAddress getIpAddress() {

    }

    @Override
    public int compareTo(RemoteServer that) {
        return that.ipAddress.;
    }

    public static class RemoteOperational extends Operational<RemoteServer,RemoteOperational> {

    }

    public static class Transport extends Support<RemoteServer, RemoteOperational, Transport, Id.Ego,> {

        public Transport(Support bus, Envoy envoy) {
            super(bus, envoy);
        }
    }

    public static RemoteServer
}
