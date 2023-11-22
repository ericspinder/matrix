package dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat;

import dev.inward.matrix.fact.authoritative.notion.house.Steward;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Root extends Steward<Ziggurat,Root> {

    public Root(Ziggurat ziggurat, ReferenceQueue<Ziggurat> referenceQueue, MatrixProtectionDomain matrixProtectionDomain) {
        super(ziggurat, referenceQueue, matrixProtectionDomain);
    }
}
