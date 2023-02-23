package dev.inward.matrix.fact.datum.protocol;

import javax.net.ServerSocketFactory;
import java.net.ProtocolFamily;

public abstract class Protocol<P extends Protocol<P>> implements ProtocolFamily {

    protected final String protocol;

    public Protocol(String protocol) {
        this.protocol = protocol;

    }

    public final String getProtocol() {
        return this.protocol;
    }

    public ServerSocketFactory
}
