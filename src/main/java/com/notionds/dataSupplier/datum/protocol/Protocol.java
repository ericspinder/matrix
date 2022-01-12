package com.notionds.dataSupplier.datum.protocol;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;

import javax.net.ServerSocketFactory;

public abstract class Protocol<D extends Protocol<D,O,C,I>,O extends Operational<D,O>,C extends ProtocolContainer<D,O,C,I,?>,I extends Id<D,I>> extends Datum<D,O,C,I> {

    private String protocol;

    public Protocol(I id, C container, String protocol) {
        super(id, container);


    }

    public ServerSocketFactory getServerSocketFactory() {
        return serverSocketFactory;
    }
}
