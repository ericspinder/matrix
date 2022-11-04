package dev.inward.matrix.datum.protocol;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Operational;

import javax.net.ServerSocketFactory;

public abstract class Protocol<D extends Protocol<D,O,C,I>,O extends Operational<D,O>,C extends ProtocolContainer<D,O,C,I,?>,I extends Identity<D,I>> extends Datum<D,O,C,I> {

    private String protocol;

    public Protocol(I id, C container, String protocol) {
        super(id, container);


    }

    public ServerSocketFactory getServerSocketFactory() {
        return serverSocketFactory;
    }
}
