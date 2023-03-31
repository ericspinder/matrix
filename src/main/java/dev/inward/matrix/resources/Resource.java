package dev.inward.matrix.resources;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.policy.Policy;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Resource<DATUM,F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> extends ReferenceQueue<DATUM> {

    protected final String className;
    protected final AtomicLong count = new AtomicLong();
    protected long warnOnTotal;
    protected final Policy[] policies;
    protected Predictable<DATUM,F,I,ID,X,?,?,?>[] predictable;

    public Resource(String className, Policy[] policies, long warnOnTotal, Predictable<DATUM,F,I,ID,X,?,?,?>[] predictable) {
        this.className = className;
        this.policies = policies;
        this.warnOnTotal = warnOnTotal;
        this.predictable = predictable;
    }

    public boolean increment() {
        long currentCount = this.count.incrementAndGet();
        return currentCount < warnOnTotal;
    }

    @Override
    public Reference<? extends DATUM> poll() {
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
