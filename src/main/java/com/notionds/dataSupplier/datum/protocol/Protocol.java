package com.notionds.dataSupplier.datum.protocol;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.operational.Operational;

import javax.net.ServerSocketFactory;

public abstract class Protocol<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends ProtocolContainer<D,O,C,?,?,?>,X extends Context<D,O,C,X>> extends Datum<D,O,C,X> {

    private String protocol;

    public Protocol(X context, C container) {
        super(context, container);
    }

    public ServerSocketFactory getServerSocketFactory() {
        return serverSocketFactory;
    }
}
