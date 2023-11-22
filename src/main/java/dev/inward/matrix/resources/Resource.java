package dev.inward.matrix.resources;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.policy.Policy;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Resource<DATUM,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends ReferenceQueue<DATUM> {

    protected final String className;
    protected final AtomicLong count = new AtomicLong();
    protected long warnOnTotal;
    protected final Policy<?,DATUM,?,S,L,PATH,F,?,?>[] policies;
    protected Predictable<DATUM,?,S,L,PATH,F,?,?,?>[] predictable;

    public Resource(String className, Policy[] policies, long warnOnTotal, Predictable<DATUM,?,S,L,PATH,F,?,?,?>[] predictable) {
        this.className = className;
        this.policies = policies;
        this.warnOnTotal = warnOnTotal;
        this.predictable = predictable;
    }

    public void increment() {
        long currentCount = this.count.incrementAndGet();
        if (currentCount < warnOnTotal);
    }

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

    public Policy[] getPolicies() {
        return policies;
    }
}
