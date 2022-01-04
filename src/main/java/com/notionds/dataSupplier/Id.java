package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;
import java.util.UUID;

public abstract class Id<D extends Notion<D,O,C,X,?>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>, I extends Id<D,O,C,X,I>> implements Comparable<Id>, Serializable {

    private final UUID uuid;
    private final C context;

    public Id(UUID uuid, C context) {
        this.uuid = uuid;
        this.context = context;
    }

    public UUID getUuid() {
        return uuid;
    }

    public C getContext() {
        return context;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Id that) )
            return false;
        return this.uuid == that.uuid;
    }
}
