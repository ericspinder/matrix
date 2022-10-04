package dev.inward.matrix.resources;

import dev.inward.matrix.clues.Policy;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Envoy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.ref.ReferenceQueue;

public class Resource<DATUM,D extends Datum<DATUM,D,V>, V extends Envoy<DATUM,D,V>> {

    protected final ReferenceQueue<DATUM> referenceQueue;
    protected final Policy[] policies;

    public Resource() {
        this(null,new ReferenceQueue<>());
    }
    public Resource(@Nullable Policy[] policies) {
        this(policies, new ReferenceQueue<>());
    }
    public Resource(@Nullable Policy[] policies, @Nonnull ReferenceQueue<DATUM> referenceQueue) {
        this.referenceQueue = referenceQueue;
        this.policies = policies;
    }

    public ReferenceQueue<DATUM> getReferenceQueue() {
        return this.referenceQueue;
    }


}
