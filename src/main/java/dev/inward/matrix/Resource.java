/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public abstract class Resource<DATUM,R extends Reference<DATUM,R,A,RESOURCE,M>,A extends Attributes<DATUM,R,A,RESOURCE,M>,RESOURCE extends Resource<DATUM,R,A,RESOURCE,M>,M extends Model<DATUM,R,A,RESOURCE,M>> extends ReferenceQueue<DATUM> {

    protected final AtomicLong sequence = new AtomicLong();
    protected final AtomicLong removed = new AtomicLong();
    protected String limitReachedMessage = null;
    protected Function<R,R> graveDigger;
    protected final M model;

    @SuppressWarnings("unchecked")
    protected A createAttributes(DATUM item) {
        try {
            return  ((Class<A>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]).getDeclaredConstructor(Map.class).newInstance(this.model.getInitialProperties(item));
        } catch (ClassCastException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param graveDigger
     */
    @SuppressWarnings("unchecked")
    public Resource(Function<R,R> graveDigger,M model) {
        this.graveDigger = graveDigger;
        this.model = model;
    }

    public long incrementAndGet() {
        long currentCount = this.sequence.incrementAndGet();
        if (currentCount < model.getWarnOnTotal()) {
            if (limitReachedMessage == null) {
//                limitReachedMessage = parent.;
            }
            //throw new MatrixException(MatrixException.Type.OverLimit,"over limit", Indicia.Focus.Admonitory, Indicia.Severity.Capacity,null);
        }
        return currentCount;
    }
    @SuppressWarnings("unchecked")
//    public final W poll2() {
//        W bringOutYourDead = (W) poll();
//        if (bringOutYourDead != null) {
//            this.removed.incrementAndGet();
//        }
//        return this.graveDigger.apply(bringOutYourDead);
//    }
    public M getModel() {
        return this.model;
    }
    public long getSequence() {
        return sequence.get();
    }
    public long getRemoved() {
        return removed.get();
    }
    public long estimateCount() {
        return this.sequence.get() - this.removed.get();
    }

}
