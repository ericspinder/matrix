package dev.inward.matrix.fact.authoritative.yard;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Spirit extends Agent<Tree,Identity.SuperEgo, Context.Path,Spirit> {


    public Spirit(Tree notion, ReferenceQueue<Tree> referenceQueue, MatrixProtectionDomain matrixProtectionDomain) {
        super(notion, referenceQueue, matrixProtectionDomain);
    }
}
