package com.notionds.dataSupplier.notion;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class Notion<DATUM extends Comparable<DATUM> & Serializable, N extends Notion<DATUM,N,B>,B extends Bus<DATUM,N,?,B,?,?,?,?>> implements Comparable<N>, Serializable {

    protected final Container<DATUM,N,?,B,?> container;
    protected transient final Class<N> nClass;

    @SuppressWarnings("unchecked")
    public Notion(B bus,Container<DATUM,N,?,B,?> container) {
        this.container = container;
        nClass = ((Class<N>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
//        operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
//        containerClass = ((Class<C>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[3]);
    }

    public Class<DATUM> adjust(Class<DATUM> classOfNotion, DATUM notion) throws Issue {
        if (notion instanceof Datum)
        throw new Issue(Issue.Type.Adjustment_Not_Available)
    }



    /**
     *
     * @param container
     * @param notion
     * @return
     */
    public U wrapNotion(C container, DATUM notion) {

    }


}
