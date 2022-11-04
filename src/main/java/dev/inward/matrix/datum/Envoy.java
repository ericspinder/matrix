package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.matter.report.DefaultFailure;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Startup;
import dev.inward.matrix.resources.Resource;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Envoy<DATUM, V extends Envoy<DATUM,V>> extends SoftReference<DATUM> implements Comparable<V>, Serializable {

    public final UUID uuid = UUID.randomUUID();
    public static final class NoOp<DATUM,V extends Envoy<DATUM,V>> extends Envoy<DATUM,V> {

        public NoOp(DATUM datum, Resource<DATUM> referenceQueue, Identity.Ego ego) {
            super(datum, referenceQueue,ego);

        }

        @Override
        protected void limitExceeded(long limit, long currentCount, Identity.Ego ego) {
            Map<String,Object> details = new HashMap<>();
            details.put("currentCount",currentCount);
            details.put("limit",limit);
            DefaultFailure defaultFailure = new DefaultFailure(UUID.randomUUID(),ego, Instant.now(),"Resource",details);
            ego.report(defaultFailure);
        }

    }

    public Envoy(DATUM datum, Resource<DATUM> resource, Identity.Ego ego) {
        super(datum, resource);
        if (!resource.increment()) {
            this.limitExceeded(resource.getWarnOnTotal(),resource.getCount(),ego);
        }

    }
    protected abstract void limitExceeded(long limit, long currentCount, Identity.Ego ego);

    @Override
    public int compareTo(V that) {
        return this.uuid.compareTo(that.uuid);
    }

}