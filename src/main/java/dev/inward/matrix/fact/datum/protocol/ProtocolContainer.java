package dev.inward.matrix.fact.datum.protocol;

import dev.inward.crud.Container;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.authoritative.Identity;

public abstract class ProtocolContainer<D extends Protocol<D,O,C,I>,O extends Operational<D,O>,C extends ProtocolContainer<D,O,C,I,B>,I extends Identity<D,I>,B extends Bus<D,O,C,I,B,?,?,?>> extends Container<D,O,C,I,B> {
    public ProtocolContainer(B bus) {
        super(bus);
    }

    public ProtocolContainer(B bus, State currentState) {
        super(bus, currentState);
    }
}
