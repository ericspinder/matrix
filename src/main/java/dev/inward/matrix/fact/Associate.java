package dev.inward.matrix.fact;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.resources.Resources;

import java.util.UUID;

public class Associate<T extends Fact,VERSION extends Comparable<VERSION>,V extends Identity.Web<VERSION,V,X>,X extends Context<X>,A extends Associate<T,VERSION,V,X,A,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>> extends Representative<T,V,X,A,NI,NX> {

    public Associate(T tracked, Resources<T,V,X,A,NI,NX> referenceQueue, UUID uuid,NI containerId, Standard<T> standard) {
        super(tracked, referenceQueue,uuid,containerId,standard);
    }

}
