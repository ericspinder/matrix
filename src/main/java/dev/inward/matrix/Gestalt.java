/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public abstract class Gestalt<DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,S>,S extends Gestalt<DATUM,V,M,R,S>> extends ReferenceQueue<DATUM> {

    protected final AtomicLong sequence = new AtomicLong();
    protected final AtomicLong removed = new AtomicLong();
    protected String limitReachedMessage = null;

    protected final Standard standard;
    protected final Class<V> viewClass;
    protected final M model;
    protected Function<R,R> graveDigger;
    protected long warnOnTotal;
    protected long hardLimit;

    public Gestalt(Standard standard) {
        this.standard = standard;
        try {
            this.viewClass = createViewClass();
            this.model = createModelInstance();
            this.graveDigger = createGraveDiggerInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    protected Class<V> createViewClass() {
        return (Class<V>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    @SuppressWarnings("unchecked")
    protected M createModelInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return ((Class<M>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]).getConstructor(Aspect[].class).newInstance((Object[])standard.getAspects());
    }
    @SuppressWarnings("unchecked")
    protected Function<R,R> createGraveDiggerInstance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (Function<R, R>) Class.forName(standard.getGraveDiggerClassName()).getDeclaredConstructor().newInstance();
    }

    public long incrementAndGet() {
        long currentCount = this.sequence.incrementAndGet();
        if (currentCount < warnOnTotal) {
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
    public long getWarnOnTotal() {
        return this.warnOnTotal;
    }

    public long getHardLimit() {
        return hardLimit;
    }

    public void setWarnOnTotal(long warnOnTotal) {
        this.warnOnTotal = warnOnTotal;
    }

    public void setHardLimit(long hardLimit) {
        this.hardLimit = hardLimit;
    }

}
