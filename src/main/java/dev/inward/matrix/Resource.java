package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.fact.Concept;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class Resource<DATUM> extends ReferenceQueue<DATUM> {

    public final Concept.Resource<?,?,?,?> parent;
    protected final String className;
    protected final AtomicLong count = new AtomicLong();
    private long warnOnTotal;
    private long hardLimit;
    private String limitReachedMessage = null;

    public Resource(Concept.Resource<?,?,?,?> parent, String className, long warnOnTotal, long hardLimit) {
        this.parent = parent;
        this.className = className;
        this.warnOnTotal = warnOnTotal;
        this.hardLimit = hardLimit;
    }

    public String getClassName() {
        return className;
    }

    public void increment() throws MatrixException {
        long currentCount = this.count.incrementAndGet();
        if (currentCount < warnOnTotal) {
            if (limitReachedMessage == null) {
                limitReachedMessage = parent.get().;
            }
            throw new MatrixException(MatrixException.Type.OverLimit,, Indicia.Focus.Admonitory, Indicia.Severity.Capacity);
        }
    }
    protected String createHardLimitMessage()

    @Override
    public final Reference<? extends DATUM> poll() {
        Reference<? extends DATUM> bringOutYourDead = super.poll();
        if (bringOutYourDead != null) {
            this.count.decrementAndGet();
        }
        return bringOutYourDead;
    }
    public long getCount() {
        return count.get();
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

    public Policy<? super Function<DATUM,?>,DATUM,P,ID,T,C,CAT,?,?,?,?,?>[] getPolicies() {
        return policies;
    }
}
