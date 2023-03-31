package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.fact.Associate;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.report.Report;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.MatrixProtectionDomain;
import dev.inward.matrix.resources.Resources;

import java.util.UUID;

public class Agent<N extends Notion<N,I,X,VERSION,EXPIRE,C>,I extends Identity<I,X>,X extends Context<X>,VERSION extends Comparable<VERSION>,EXPIRE extends Comparable<EXPIRE>,C extends Security<VERSION,EXPIRE,C>,A extends Agent<N,I,X,VERSION,EXPIRE,C,A>> extends Associate<N,I,X,VERSION,EXPIRE,C,A,I,X> {

    protected final MatrixProtectionDomain matrixProtectionDomain;

    public Agent(N notion, Resources<N,I,X,A,I,X> referenceQueue, UUID uuid, Standard<N> standard, MatrixProtectionDomain matrixProtectionDomain) {
        super(notion,referenceQueue,uuid,notion.getIdentity(),standard);
        this.matrixProtectionDomain = matrixProtectionDomain;
    }
    public void report(Report report) {

    }

}
