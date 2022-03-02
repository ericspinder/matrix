package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.aggregation.Activity;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.rubric.Complication;


import java.time.Clock;
import java.util.Map;

public abstract class Edition<X extends Context<X>> extends ClassLoader {

    private final X context;
    private final Activity activity;
    private final Clock clock;
    private final Map<String, Meta> metas;

    public Edition(X context, Activity activity, Clock clock, Map<String,Meta> metas) {
        this.context = context;
        this.activity = activity;
        this.clock = clock;
        this.metas = metas;
    }

    public <F extends Fact<F,O,I,X,B,?,?,?,?,?,?>,O extends Operational<F,O,I,X>,I extends Id<I,X>,B extends Bus<F,I,X,B>> O assignOperational(I id, Complication[] complications) {

    }

    public X getContext() {
        return context;
    }

    public Activity getActivity() {
        return activity;
    }

    public Clock getClock() {
        return clock;
    }
//
//    public Meta getMeta(Datum datum) {
//        metas.getOrDefault(datum.getClass().getCanonicalName());
//    }
}
