package com.notionds.dataSupplier.library;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.datum.fact.notion.Aspect;
import com.notionds.dataSupplier.datum.fact.notion.Omnibus;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.setting.Track;
import dev.inward.matrix.gathering.Lexicon;

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

        public Transport(Support bus, Track track) {
            super(bus, track);
        }
    }

    public static RemoteServer
}
