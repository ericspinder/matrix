package dev.inward.matrix.resources;

import dev.inward.matrix.clues.Policy;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Envoy;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.matter.worker.Canceled_forTopic;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Resource<DATUM> extends ReferenceQueue<DATUM> {

    protected AtomicInteger count;
    protected long warnCount;
    protected long limit;
    protected final Policy[] policies;

    public Resource(@Nullable Policy[] policies, String resourceName) {
        this.policies = policies;
        this.warnCount = (long)((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().specification().getOptions().get("dev.inward.matrix.resource." + resourceName + ".sleep");
        this.limit = (long)((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().specification().getOptions().get("dev.inward.matrix.resource." + resourceName + ".snooze");
    }

    public ReferenceQueue<DATUM> increment() {
        int currentCount = this.count.incrementAndGet();
        if ( currentCount > warnCount) {
            ((Factory)this.getClass().getClassLoader()).getEngine().
            if (currentCount > limit) {

                throw new Canceled_forTopic(UUID.randomUUID(), null,)
            }

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

}
