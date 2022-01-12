package com.notionds.dataSupplier.datum.id;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.operational.Operational;



public class Session<D extends Datum<D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I,?>,I extends Session<D,O,C,I>> extends Id<D,I> {

    @Unspoken()
    private final String[] magicWords;

    public Session(String id, Context<D> context, String[] magicWords) {
        super(id, context);
        this.magicWords = magicWords;
    }

    public String[] getMagicWords() {
        return this.magicWords;
    }

    @Override
    public int compareTo(I o) {
        return 0;
    }
}
