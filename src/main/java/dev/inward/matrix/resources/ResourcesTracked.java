package dev.inward.matrix.resources;

import dev.inward.matrix.fact.Associate;
import dev.inward.matrix.fact.tracked.Controller;
import dev.inward.matrix.fact.tracked.Tracked;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.policy.Policy;

public class ResourcesTracked<T extends Tracked<T,I,X,VERSION,EXPIRE,C>,I extends Identity<I,X>,X extends Context<X>,VERSION extends Comparable<VERSION>,EXPIRE extends Comparable<EXPIRE>,C extends Controller<VERSION,EXPIRE,C>,ASS extends Associate<T,I,X,VERSION,EXPIRE,C,ASS,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>> extends Resources<T,I,X,ASS,NI,NX> {

    public ResourcesTracked(Policy[] policies) {
        super(policies);
    }

}
