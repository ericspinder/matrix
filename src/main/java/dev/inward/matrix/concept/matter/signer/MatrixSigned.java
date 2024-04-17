package dev.inward.matrix.concept.matter.signer;

import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;

import java.security.CodeSigner;
import java.util.UUID;

public class MatrixSigned extends Signed<MatrixSigned, Identity.Gate, Context.Path> {


    protected final Edition[] endorsed;
    protected final Edition previous;

    public MatrixSigned(UUID uuid, Identity.Gate containerId, CodeSigner codeSigner, Edition previous, Edition[] endorsed) {
        super(uuid,containerId,"dev.inward.source.matter.signer.MatrixSigner",codeSigner);
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
