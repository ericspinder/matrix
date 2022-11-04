package dev.inward.matrix.resources;

import dev.inward.matrix.clues.Policy;
import dev.inward.matrix.datum.Identity;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Resource<DATUM> extends ReferenceQueue<DATUM> implements Comparable<DATUM> {

    protected AtomicLong count;
    protected long warnOnTotal;
    protected final Policy[] policies;

    public Resource(Policy[] policies, long warnOnTotal) {
        this.policies = policies;
        this.warnOnTotal = warnOnTotal;
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
    @Override
    public final int compareTo(DATUM that) {
        return this.getClass().getCanonicalName().compareTo(that.getClass().getCanonicalName());
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
