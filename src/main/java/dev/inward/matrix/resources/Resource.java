package dev.inward.matrix.resources;

import dev.inward.matrix.clues.Policy;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.matter.report.DefaultFailure;
import dev.inward.matrix.matter.report.DefaultWarning;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Resource<DATUM> extends ReferenceQueue<DATUM> implements Comparable<DATUM> {

    protected AtomicInteger count;
    protected long warnCount;
    protected long limit;
    protected final Policy[] policies;


    public Resource(Policy[] policies) {
        this.policies = policies;
        this.warnCount = (long)((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().specification().getOptions().get("dev.inward.matrix.resource.warn");
        this.limit = (long)((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().specification().getOptions().get("dev.inward.matrix.resource.limit");
    }

    public ReferenceQueue increment(Identity cid) {
        int currentCount = this.count.incrementAndGet();
        if ( currentCount > warnCount) {
            ((Factory)this.getClass().getClassLoader()).getEngine().getOperational().
            if (currentCount > limit) {
                Map<String,Object> details = new HashMap<>();
                details.put("currentCount",Integer.toString(currentCount));
                throw new DefaultFailure(UUID.randomUUID(), cid, Instant.now(),"Resource",details);
            }

            ((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().report(new DefaultWarning(UUID.randomUUID(),cid,""));
        }
        return this;
    }

    @Override
    public Reference<? extends DATUM> poll() {
        Reference<? extends DATUM> bringOutYourDead = super.poll();
        if (bringOutYourDead != null) {

        }
        return bringOutYourDead;
    }
    @Override
    public final int compareTo(DATUM that) {
        return this.getClass().getCanonicalName().compareTo(that.getClass().getCanonicalName());
    }

}
