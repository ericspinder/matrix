package dev.inward.matrix.fact.matter.signer;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.Context;

import java.security.CodeSigner;
import java.util.UUID;

public abstract class Signer<S extends Signer<S>> extends Matter<S> {

    protected final CodeSigner codeSigner;

    public Signer(UUID uuid, CI containerId, String locus, CodeSigner codeSigner) {
        super(uuid, containerId, codeSigner.getTimestamp().getTimestamp().toInstant(), new Indicia(locus, Indicia.Focus.Assembly, Indicia.Severity.Nominal));
        this.codeSigner = codeSigner;
    }
    public CodeSigner getCodeSigner() {
        return this.codeSigner;
    }
}
