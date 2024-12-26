package dev.inward.matrix;

import dev.inward.matrix.predictable.Complication;
import dev.inward.matrix.predictable.Matter;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public abstract class Resource<DATUM,W extends Ware<DATUM,W,A>,A extends Attributes<DATUM,W,A>> extends ReferenceQueue<DATUM> {

    protected final Standard standard;
    protected final AtomicLong sequence = new AtomicLong();
    protected final AtomicLong removed = new AtomicLong();
    protected String limitReachedMessage = null;
    protected Function<W,W> graveDigger;


    @SuppressWarnings("unchecked")
    protected A createAttributes(DATUM datum) {
        try {
            return ((Class<A>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]).getDeclaredConstructor(Resource.class,Object.class).newInstance(this, datum);
        } catch (ClassCastException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    protected Model getModel(Class<DATUM> datumClass) {

    }
    protected void populate(Properties properties, DATUM datum) {

    }

    /**
     *
     * @param standard
     * @param graveDigger
     */
    public <M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> Resource(Standard standard, Function<W,W> graveDigger) {
        this.standard = standard;
        this.graveDigger = graveDigger;
    }

    public long incrementAndGet() {
        long currentCount = this.sequence.incrementAndGet();
        if (currentCount < standard.getWarnOnTotal()) {
            if (limitReachedMessage == null) {
//                limitReachedMessage = parent.;
            }
            //throw new MatrixException(MatrixException.Type.OverLimit,"over limit", Indicia.Focus.Admonitory, Indicia.Severity.Capacity,null);
        }
        return currentCount;
    }
    @SuppressWarnings("unchecked")
    public final W poll2() {
        W bringOutYourDead = (W) poll();
        if (bringOutYourDead != null) {
            this.removed.incrementAndGet();
        }
        return this.graveDigger.apply(bringOutYourDead);
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




//    public Policy<? super Function<DATUM,?>,DATUM,P,ID,T,C,CAT,?,?,?,?,?>[] getPolicies() {
//        return policies;
//    }
}
