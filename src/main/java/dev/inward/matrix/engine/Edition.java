package dev.inward.matrix.engine;

import dev.inward.matrix.matter.signer.MatrixSigner;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Edition extends CodeSource implements Comparable<Edition> {

    protected final Version version;
    protected final MatrixSigner matrixSigner;


    public Edition(URL url, Version version, MatrixSigner matrixSigner) {
        super(url,new CodeSigner[] {matrixSigner.getCodeSigner()});
        this.version = version;
        this.matrixSigner = matrixSigner;
    }
    public MatrixSigner matrixSigner() {
        return this.matrixSigner;
    }

    public static class Version implements Comparable<Version> {
        public static final Version Aforementioned = new Version(".01"); // can't call it 'this'

        private final String version;
        public Version(String version) {
            this.version = version;
        }
        public String get() {
            return this.version;
        }
        public int compareTo(Version that) {
            return this.version.compareTo(that.version);
        }

    }
    public int compareTo(Edition that) {
        return this.version.compareTo(that.version);
    }
}
