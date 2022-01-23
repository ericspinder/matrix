package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Session<D extends Session<D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<D,I,?>> extends Datum<D,D,O,C,I> {

    @Unspoken()
    private final String[] magicWords;

    public Session(C container, String[] magicWords) {
        super(container);
        this.magicWords = magicWords;
    }

    public String[] getMagicWords() {
        return this.magicWords;
    }

}
