package com.notionds.dataSupplier.datum.protocol;

import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

public abstract class ProtocolContainer<D extends Protocol<D,O,C,I>,O extends Operational<D,O>,C extends ProtocolContainer<D,O,C,I,B>,I extends Id<D,I>,B extends Bus<D,O,C,I,B,?,?,?>> extends Container<D,O,C,I,B> {
    public ProtocolContainer(B bus) {
        super(bus);
    }

    public ProtocolContainer(B bus, State currentState) {
        super(bus, currentState);
    }
}
