package dev.inward.matrix.fact.authoritative.notion.house;

import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public abstract class Steward<H extends House<H,P>,P extends Steward<H,P>> extends Agent<H, Identity.Ghost, Context.Ethereal,P> {

    public Steward(H notion, ReferenceQueue<H> referenceQueue, MatrixProtectionDomain matrixProtectionDomain) {
        super(notion, referenceQueue, matrixProtectionDomain);
    }
}
