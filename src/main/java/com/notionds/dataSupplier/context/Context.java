package com.notionds.dataSupplier.context;

import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.id.SuperEgo;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.provider.Receipt;

import java.lang.reflect.ParameterizedType;


public abstract class Context<D extends Datum<D,?,?,I>,I extends Id<D,I>> {

    public static class Production<D extends Datum<D,?,?,I>,I extends Id<D,I>> extends Context<D,I> {

        public Production(Receipt<D, ?, ?, I> parent, String path) {
            super(parent, path);
        }

        @Override
        boolean isProduction() {
            return true;
        }
    }

    private transient Receipt<D,?,?,I> parent;
    private final String path;
    private final String name;
    public Context(Receipt<D,?,?,I> parent, String path) {
        this(parent, path,null);
    }
    public Context(Receipt<D,?,?,I> parent, String path, String name) {
        Class<I> iClass = (Class<I>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        if (!iClass.isAssignableFrom(SuperEgo.class) && parent == null) {
            throw new NotionStartupException(NotionStartupException.Type.No_Parent, iClass);
        }
        this.parent = parent;
        this.path = path;
        if (name != null) {
            this.name = name;
        } else {
            this.name = ((Class<D>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getCanonicalName();
        }
    }

    @Override
    public int compareTo(Context that) {
        if (this.parent.refersTo(that.parent)) {
            return this.path.compareTo(that.path)
        }
        else {
            return this.parent.compareTo(that.parent);
        }
    }
    abstract boolean isProduction();
}

