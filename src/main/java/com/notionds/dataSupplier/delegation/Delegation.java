package com.notionds.dataSupplier.delegation;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.reflect.ParameterizedType;

public abstract class Delegation<N, O extends Operational<N,W,T>, W extends Wrapper<N,O,T>,T extends Container<N,O,W>> {

    protected final O operational;
    protected final Class<N> delegateClass;
    protected final Class<O> operationalClass;
    protected final Class<T> containerClass;

    @SuppressWarnings("unchecked")
    public Delegation(O operational, ClassLoader classLoader) {
        this.operational = operational;
        delegateClass = ((Class<N>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
        containerClass = ((Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[3]);

    }


    /**
     *
     * @param container
     * @param delegate
     * @return
     */
    public abstract W getDelegate(T container, N delegate, Object[] args);


}
