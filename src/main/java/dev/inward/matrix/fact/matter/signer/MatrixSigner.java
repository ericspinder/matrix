package dev.inward.matrix.fact.matter.signer;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.engine.Edition;

import java.security.CodeSigner;
import java.util.UUID;

public class MatrixSigner extends Signer<MatrixSigner, Identity.SuperEgo,Context.Service> {


    protected final Edition[] endorsed;
    protected final Edition previous;

    public MatrixSigner(UUID uuid, Identity.SuperEgo containerId,CodeSigner codeSigner, Edition previous, Edition[] endorsed) {
        super(uuid,containerId,"dev.inward.matrix.matter.signer.MatrixSigner",codeSigner);
        this.previous = previous;
        this.endorsed = endorsed;
    }

    public Edition[] getEndorsed() {
        return this.endorsed;
    }
    public Edition getPrevious() {
        return this.previous;
    }
}
