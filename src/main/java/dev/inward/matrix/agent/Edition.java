package dev.inward.matrix.agent;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public final class Edition extends CodeSource implements Comparable<Edition> {

    protected final Version version;

    public Edition(URL url, CodeSigner[] signers, Version version) {
        super(url,signers);
        this.version = version;
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
