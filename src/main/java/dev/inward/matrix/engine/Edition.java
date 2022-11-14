package dev.inward.matrix.engine;

import dev.inward.matrix.fact.matter.signer.MatrixSigner;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Edition extends CodeSource implements Comparable<Edition> {

    protected final Version version;
    protected final MatrixSigner matrixSigner;
    public static final Version<String> Aforementioned = new Version<>(".01") {}; // can't call it 'this'


    public Edition(URL url, Version version, MatrixSigner matrixSigner) {
        super(url,new CodeSigner[] {matrixSigner.getCodeSigner()});
        this.version = version;
        this.matrixSigner = matrixSigner;
    }
    public MatrixSigner matrixSigner() {
        return this.matrixSigner;
    }

    public int compareTo(Edition that) {
        return this.version.compareTo(that.version);
    }
}
