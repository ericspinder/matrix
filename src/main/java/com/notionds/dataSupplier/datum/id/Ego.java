package com.notionds.dataSupplier.datum.id;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Id;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.operational.Operational;

import java.util.UUID;

public abstract class Ego<D extends Notion<D,O,C,X,I>,O extends Operational<D,O>,C extends Container<D,O,C,?,?>,X extends Context<D,O,C,X>, I extends Ego<D,O,C,X,I>> extends Id<D,O,C,X,I> {
    public Ego(UUID uuid, C context) {
        super(uuid, context);
    }
}
