package com.notionds.dataSupplier.datum.notion.fact;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Id;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.operational.Operational;


public abstract class Fact<D extends Fact<D,O,C,X,I,B>,O extends Operational<D,O>,C extends Container<D,O,C,>,X extends Context<D,O,C,X>,I extends Basis<D,O,C,X,I,B>,B extends Bus<D,O,C,D,B,?,?,?,?> extends Notion<D,O,C,X,I,B> {

    public Fact(I id, X context, C container, B bus) {
        super(id,context,container,bus);
    }

}
