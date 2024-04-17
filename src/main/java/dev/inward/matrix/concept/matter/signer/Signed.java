package dev.inward.matrix.concept.matter.signer;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Matter;

import java.security.CodeSigner;
import java.time.Instant;

public abstract class Signed<S extends Scheme<S,L>,L extends Library<S,L>,SIGNER extends Signed<S,L,SIGNER>> extends Matter<S,L,SIGNER,Endorsement> {

    protected final CodeSigner codeSigner;

    public Signed(Rubric<S,L,SIGNER> rubric, Instant[] occurrences, boolean settled, CodeSigner codeSigner) {
        super(rubric, occurrences, settled);
        this.codeSigner = codeSigner;
    }
    public CodeSigner getCodeSigner() {
        return this.codeSigner;
    }
}
