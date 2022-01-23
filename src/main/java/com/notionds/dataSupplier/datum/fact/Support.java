package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.Bus;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.operational.Operational;
import dev.inward.matrix.setting.Gate;

public abstract class Support<D extends Fact<D,O,C,I>,O extends Operational<D,O>,C extends Support<D,O,C,I,B>,I extends Ego<?,I,?>,B extends Bus<D,O,C,I,B,?,?,?>> extends Container<D,O,C,I> {

    @Unspoken
    private B bus;
    @Unspoken
    private final Gate gate;

    public Support(B bus, Gate gate) {
        super();
        this.bus = bus;
        this.gate = gate;
    }

    public Gate getGate() {
        return this.gate;
    }
}
