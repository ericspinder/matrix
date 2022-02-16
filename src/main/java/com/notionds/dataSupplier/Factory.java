package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class Factory<D extends Datum<?,D,O,?,?>,O extends Operational<D,O>,B extends Bus<D,O,?,?,B,?,?,?>,P extends Provider<D,O,?,?>,M extends Meta<D>,F extends Factory<D,O,B,P,M,F>> implements Comparable<F>, Serializable {

    private Map<String, B> busRoutes = new ConcurrentHashMap<>();
    private O options;

    public Factory(O options, LinkedBlockingDeque<P> providers) {
        this.options = options;
    }

    public void addProvider(LinkedBlockingDeque<P> providers) {

    }
//    public <N, W extends Datum<N,?,T>,T extends Container<N,?,W>> W wrap(N delegate, Class<N> delegateClass, Object[] args) {
//        if (this.busRoutes.containsKey(delegateClass.getCanonicalName())) {
//            Bus<?,?,?,?,?,?,?,?,?,?> bus = this.busRoutes.get(delegateClass.getCanonicalName());
//            Task[] tasks = new Task[]{bus.operational.};
//            return bus.wrap(delegate,args, )
//        }
//        throw new NotionStartupException(NotionStartupException.Type.SoftReference_Problem, this.getClass());
//    }
}