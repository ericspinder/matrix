package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.options.Options;

import java.io.Serializable;

/**
 * Holding the Datum will prevent garbage collection for it's DATUM
 * @param <DATUM> Any Comparable and Serializable Object including primitives which are to be wrapped
 * @param <N>
 * @param <O>
 * @param <B>
 * @param <C>
 */
public abstract class Datum<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O,D>,C extends Container<DATUM,O,C,D,B>,D extends Datum<DATUM,O,C,D,B>, B extends Bus<DATUM,O,C,D,B,?,?,?>> implements Comparable<Datum>, Serializable {

    private final C container;

    public Datum(C container) {
        this.container = container;
    }

    public C getContainer() {
        return this.container;
    }

}
