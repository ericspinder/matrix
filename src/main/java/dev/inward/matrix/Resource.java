package dev.inward.matrix;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public abstract class Resource<DATUM,W extends Ware<DATUM,W,A>,A extends Attributes<DATUM,W,A>> extends ReferenceQueue<DATUM> {

    protected final Standard standard;
    protected final AtomicLong sequence = new AtomicLong();
    protected final AtomicLong removed = new AtomicLong();
    protected String limitReachedMessage = null;
    protected Function<W,W> graveDigger;
    protected final Function<DATUM,Model<DATUM,W,A>> modelMaker;

    @SuppressWarnings("unchecked")
    protected A createAttributes(DATUM datum) {
        try {
            A attributes = ((Class<A>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]).getDeclaredConstructor(Model.class).newInstance(this.modelMaker.apply(datum));
            this.populate(attributes,datum);
            return attributes;
        } catch (ClassCastException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Override this method to populate the attributes of the datum instance being wrapped
     * @param attributes the new Attributes
     * @param datum the datum instance being wrapped
     */
    protected void populate(A attributes, DATUM datum) {
        //this space deliberately left blank
    }

    /**
     *
     * @param standard
     * @param graveDigger
     */
    @SuppressWarnings("unchecked")
    public Resource(Standard standard, Function<W,W> graveDigger, Function<DATUM,Model<DATUM,W,A>> modelMaker) {
        this.standard = standard;
        this.graveDigger = graveDigger;
        if (modelMaker == null) {
            try {
                this.modelMaker = (Function<DATUM, Model<DATUM,W,A>>) Class.forName(this.standard.modelMakerClass).getConstructor().newInstance();
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                     InvocationTargetException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            this.modelMaker = modelMaker;
        }
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

}
