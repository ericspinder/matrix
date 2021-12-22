package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

/**
 * Holding the Datum will prevent garbage collection for it's NOTION
 * @param <NOTION>
 * @param <O> Operational, not kept in this object but available from the Bus in the Container
 * @param <C> Container, the container associated with this Datum
 * @param <B> Bus, not kept in this object but available in the Container
 */
public abstract class Datum<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,?,?,?,?>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>> implements Comparable<U>, Serializable {

    private final NOTION notion;
    private final C container;

    public Datum(NOTION notion, C container) {
        this.notion = notion;
        this.container = container;
        this.init(notion, container);
    }

    public C getContainer() {
        return this.container;
    }

    public NOTION getDelegate() {
        return this.notion;
    }

    protected abstract void init(NOTION notion, C container);

}
