/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept;

import dev.inward.matrix.*;
import dev.inward.matrix.concept.fact.addressed.depot.standard.Standard;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public abstract class Concept<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET>> extends ReferenceQueue<TARGET> {

    public interface Referenced<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET>,C extends Concept<TARGET,V,M>,X extends Context<TARGET,V,M,C>> {
        Seat<TARGET> getReference();
        void setReference(Seat<TARGET> reference);
    }
    private final AtomicLong sequence = new AtomicLong();
    protected final AtomicLong removed = new AtomicLong();
    //protected final Map<Action.ActionType, Action[]> restraints;

    protected final Standard standard;
    protected final Class<V> viewClass;
    protected final Class<? extends Reference<TARGET>> referenceClass;
    protected final Function<Reference<? extends TARGET>,Reference<? extends TARGET>> graveDigger;
    protected final M model;
    protected long warnOnTotal;
    protected long hardLimit;

    public Concept(Standard standard) {;
        this.standard = standard;
        try {
            this.viewClass = createViewClass();
            this.referenceClass = assignReferenceClass();
            this.model = createModelInstance();
            this.graveDigger = createGraveDiggerInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized Long getSequenceNumber() {
        try {
            return sequence.incrementAndGet();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.sequence.set(Long.MIN_VALUE);
            return Long.MIN_VALUE;
        }
    }
    protected Map<String,?> properties(Standard standard) {

    }
    @SuppressWarnings("unchecked")
    protected Class<V> createViewClass() {
        return (Class<V>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    @SuppressWarnings("unchecked")
    protected Class<? extends Reference<TARGET>> assignReferenceClass() throws ClassNotFoundException {
        return (Class<? extends Reference<TARGET>>) Class.forName(standard.getReferenceClassName());
    }

    @SuppressWarnings("unchecked")
    protected M createModelInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return ((Class<M>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]).getConstructor(Aspect[].class).newInstance((Object[])standard.getAspects());
    }
    @SuppressWarnings("unchecked")
    protected Function<Reference<? extends TARGET>,Reference<? extends TARGET>> createGraveDiggerInstance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (Function<Reference<? extends TARGET>,Reference<? extends TARGET>>) Class.forName(standard.getGraveDiggerClassName()).getDeclaredConstructor(Concept.class).newInstance(this);
    }

    public long incrementAndGet(Seat seat) {
        long currentCount = this.sequence.incrementAndGet();
        if (currentCount < warnOnTotal) {
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
    public long estimateCount(long removed) {
        return this.sequence.get() - removed;
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

    public Class<? extends Reference<TARGET>> getReferenceClass() {
        return referenceClass;
    }

    public Class<V> getViewClass() {
        return viewClass;
    }

    public Standard getStandard() {
        return standard;
    }

    public Reference<? extends TARGET> reaper(Reference<? extends TARGET> departed) {
        if (departed != null) {
            long estimatedCount = this.estimateCount(this.removed.incrementAndGet());
            if (estimatedCount <= 0) {

            }
            return this.graveDigger.apply(departed);
        }
        return null;
    }

    @Override
    public Reference<? extends TARGET> poll() {
        return reaper(super.poll());
    }

    @Override
    public Reference<? extends TARGET> remove() throws InterruptedException {
        return reaper(super.remove());
    }

    @Override
    public Reference<? extends TARGET> remove(long timeout) throws InterruptedException {
        return reaper(super.remove(timeout));
    }

    public Function<Reference<? extends TARGET>, Reference<? extends TARGET>> getGraveDigger() {
        return graveDigger;
    }
}
