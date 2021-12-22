package com.notionds.dataSupplier.notion;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class Notion<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,?,?,?,?>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>> {

    protected transient final O operational;
    protected final B bus;
    protected transient final Class<NOTION> delegateClass;
    protected transient final Class<O> operationalClass;
    protected transient final Class<C> containerClass;

    @SuppressWarnings("unchecked")
    public Notion(O operational, B bus) {
        this.operational = operational;
        this.bus = bus;
        delegateClass = ((Class<NOTION>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
        containerClass = ((Class<C>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[3]);
    }

    public Class<NOTION> adjust(Class<NOTION> classOfNotion, ) throws Issue {
        if (notion instanceof U)
        throw new Issue(Issue.Type.Adjustment_Not_Available)
    }



    /**
     *
     * @param container
     * @param notion
     * @return
     */
    public U wrapNotion(C container, NOTION notion) {

    }


}
