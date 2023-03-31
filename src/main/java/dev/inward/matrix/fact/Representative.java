package dev.inward.matrix.fact;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.resources.Resources;

import java.util.UUID;

public class Representative<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> extends Envoy<F> {

    protected final UUID uuid;

    public Representative(F f, Resources<F,I,ID,X> referenceQueue, UUID uuid) {
        super(f, referenceQueue);
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
