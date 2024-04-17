package dev.inward.matrix.engine;

import dev.inward.matrix.concept.matter.signer.MatrixSigned;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Edition extends CodeSource implements Comparable<Edition> {

    protected final Variant variant;
    protected final MatrixSigned matrixSigner;

    public Edition(URL url, Variant variant, MatrixSigned matrixSigner) {
        super(url,new CodeSigner[] {matrixSigner.getCodeSigner()});
        this.variant = variant;
        this.matrixSigner = matrixSigner;
    }
    public MatrixSigned matrixSigner() {
        return this.matrixSigner;
    }

    public int compareTo(Edition that) {
        return this.variant.compareTo(that.variant);
    }
}
