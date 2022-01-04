package com.notionds.dataSupplier.datum.notion.fact;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.host.Host;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.Id;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Basis<D extends Fact<D,O,C,X,?,?>,O extends Operational<D,O>,C extends Container<D,O,C,?,?,?>,X extends Context<D,O,C,X>, I extends Id<D,O,C,X,I>,H extends House> extends Id<D,O,C,X,I> {

    private final H house;
    public Basis(C context) {
        super(context);
    }
}
