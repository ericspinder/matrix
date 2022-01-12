package com.notionds.dataSupplier.datum.notion.fact;

import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.Datum;

import java.io.Serializable;

public abstract class Id<D extends Datum<D,?,?,I>, I extends Id<D,I>> implements Comparable<I>, Serializable {

    private final String id;
    private final Context<?,?> context;

    public Id(String id, Context<?,?> context) {
        this.id = id;
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public Context<?,?> getContext() {
        return context;
    }

    @Override
    public int compareTo(I that) {
        if (this.context.equals(that.getContext())) {
            if (this.id.equals(that.getId())) {
                return 0;
            }
            return this.id.compareTo(that.getId());
        }
        return this.context.compareTo(that.getContext());
    }
}
