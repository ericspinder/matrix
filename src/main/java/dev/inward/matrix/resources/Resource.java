package dev.inward.matrix.resources;

import dev.inward.matrix.Library;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.policy.Policy;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Resource<DATUM,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends ReferenceQueue<DATUM> {

    protected final L library;
    protected final String className;
    protected final AtomicLong count = new AtomicLong();
    private long warnOnTotal;
    private long hardLimit;

    private String limitReachedMessage = null;
    protected final Policy<?,DATUM,?,S,L,PATH,F,?,?>[] policies;

    public Resource(L library, String className, Policy[] policies, long warnOnTotal, long hardLimit) {
        this.library = library;
        this.className = className;
        this.policies = policies;
        this.warnOnTotal = warnOnTotal;
        this.hardLimit = hardLimit;
    }

    public L getLibrary() {
        return library;
    }

    public String getClassName() {
        return className;
    }

    public void increment() throws MatrixException {
        long currentCount = this.count.incrementAndGet();
        if (currentCount < warnOnTotal) {
            if (limitReachedMessage == null) {
                limitReachedMessage = library.(this.className,this.warnOnTotal,this.l.l);
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

    public Policy[] getPolicies() {
        return policies;
    }
}
