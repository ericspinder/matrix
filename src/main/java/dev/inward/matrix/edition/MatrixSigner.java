package dev.inward.matrix.edition;

import java.security.CodeSigner;
import java.security.Timestamp;
import java.security.cert.CertPath;

public abstract class MatrixSigner {

    protected final Edition endorsed;
    protected final Edition previous;
    protected final CodeSigner[] codeSigners;
    /**
     * Constructs a CodeSigner object.
     *
     * @param signerCertPath The signer's certificate path.
     *                       It must not be {@code null}.
     * @param timestamp      A signature timestamp.
     *                       If {@code null} then no timestamp was generated
     *                       for the signature.
     * @throws NullPointerException if {@code signerCertPath} is
     *                              {@code null}.
     */
    public MatrixSigner(CertPath signerCertPath, Timestamp timestamp,Edition previous,Edition endorsed) {
        this(new CodeSigner[] {new CodeSigner(signerCertPath,timestamp)},previous,endorsed);

    }
    public MatrixSigner(CodeSigner[] codeSigners, Edition previous, Edition endorsed) {
        this.codeSigners = codeSigners;
        this.previous = previous;
        this.endorsed = endorsed;
    }

    public CodeSigner[] codeSigners() {
        return codeSigners;
    }
}
