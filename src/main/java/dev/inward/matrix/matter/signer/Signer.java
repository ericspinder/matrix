package dev.inward.matrix.matter.signer;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.matter.Matter;

import java.security.CodeSigner;
import java.util.UUID;

public abstract class Signer<S extends Signer<S,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<S,CI,CX> {

    protected final CodeSigner codeSigner;

    public Signer(UUID uuid, CI containerId, String locus, CodeSigner codeSigner) {
        super(uuid, containerId, codeSigner.getTimestamp().getTimestamp().toInstant(), new Indicia(locus, Indicia.Focus.Assembly, Indicia.Severity.Nominal));
        this.codeSigner = codeSigner;
    }
    public CodeSigner getCodeSigner() {
        return this.codeSigner;
    }
}
