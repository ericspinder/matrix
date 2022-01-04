package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.operational.Operational;
import dev.inward.matrix.id.Ego;

import java.time.Duration;

public abstract class Promise<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>,E extends Ego<E>> extends Datum<D,O,C,X> {

    private final E maker;

    public Promise(X context, C container, E maker) {
        super(context, container);
        this.maker = maker;
    }
    private Duration currentAverage;
    private Duration variation;

    public final E getMaker() {
        return this.maker;
    }
}
