package dev.inward.matrix.domain;

import dev.inward.crud.Support;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.operational.Operational;

import java.net.InetAddress;

public final class RemoteServer extends Fact<RemoteServer, RemoteServer.RemoteOperational, RemoteServer.Transport, Identity.Id> {

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

    public static class RemoteOperational extends Operational<RemoteServer,RemoteOperational,> {

    }

    public static class Transport extends Support<RemoteServer, RemoteOperational, Transport, Identity.Id,> {

        public Transport(Support bus, Envoy envoy) {
            super(bus, envoy);
        }
    }

    public static RemoteServer
}
