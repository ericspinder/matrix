package dev.inward.matrix.fact.datum.protocol;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.authoritative.notion.concept.Concept;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class ProtocolPort<P extends ProtocolPort<P>> {

    protected final Concept concept;
    protected final Protocol protocol;
    protected final int port;

    public ProtocolPort(Concept concept, Protocol protocol, int port) {
        this.concept = concept;
        this.protocol = protocol;
        this.port = port;
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }
    public URL getURL(Domain domain) throws MalformedURLException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(protocol.label).append(protocol.scheme).append(domain.toString());
        if (port != protocol.defaultPort) {
            stringBuilder.append(protocol.defaultPortFail).append(port);
        }
        return new URL(stringBuilder.toString());
    }

//    public ServerSocketFactory
}
