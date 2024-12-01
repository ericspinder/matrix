package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.fact.datum.Envoy;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class Resource<DATUM,W extends Ware<DATUM,W>> extends ReferenceQueue<DATUM> {

    public final Representitive<?,?,?,?,?> parent;
    protected final String className;
    protected final AtomicLong sequence = new AtomicLong();
    protected final AtomicLong removed = new AtomicLong();
    protected long warnOnTotal;
    protected long hardLimit;
    protected String limitReachedMessage = null;


    protected Function<W,W> graveDigger;

    /**
     *
     * @param parent
     * @param className
     * @param warnOnTotal
     * @param hardLimit
     * @param graveDigger
     */
    public Resource(Representitive<?,?,?,?,?> parent, String className, long warnOnTotal, long hardLimit, Function<W,W> graveDigger) {
        this.parent = parent;
        this.className = className;
        this.warnOnTotal = warnOnTotal;
        this.hardLimit = hardLimit;
        this.graveDigger = graveDigger;
    }

    public String getClassName() {
        return className;
    }

    public long incrementAndGet() throws MatrixException {
        long currentCount = this.sequence.incrementAndGet();
        if (currentCount < warnOnTotal) {
            if (limitReachedMessage == null) {
//                limitReachedMessage = parent.;
            }
            throw new MatrixException(MatrixException.Type.OverLimit,"over limit", Indicia.Focus.Admonitory, Indicia.Severity.Capacity,null);
        }
        return currentCount;
    }
    @SuppressWarnings("unchecked")
    @Override
    public final W poll() {
        W bringOutYourDead = (W) super.poll();
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


    public long getWarnOnTotal() {
        return warnOnTotal;
    }

    public void setWarnOnTotal(long warnOnTotal) {
        this.warnOnTotal = warnOnTotal;
    }

    public long getHardLimit() {
        return hardLimit;
    }

    public void setHardLimit(long hardLimit) {
        this.hardLimit = hardLimit;

    }

//    public Policy<? super Function<DATUM,?>,DATUM,P,ID,T,C,CAT,?,?,?,?,?>[] getPolicies() {
//        return policies;
//    }
}
