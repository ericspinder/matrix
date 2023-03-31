package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Mortal<C extends Concept<C,M>,M extends Mortal<C,M>> extends Agent<C,Identity.Ego, Context.Ethereal,M> {

    public Mortal(C concept, ReferenceQueue<C> referenceQueue, MatrixProtectionDomain matrixProtectionDomain) {
        super(concept, referenceQueue, matrixProtectionDomain);
    }
    public boolean matter(Identity.Ego reporter, Matter<?,?,?> matter) {
        reporter.getContext().getAuthority().
    }
}
