package dev.inward.matrix.Agent;

import dev.inward.matrix.Addressable;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Edition<E extends Edition<E>> extends CodeSource implements Addressable<E> {

    protected final Version version;

    public Edition(URL url, CodeSigner[] signers, Version version) {
        super(url,signers);
        this.version = version;
    }

    @Override
    public int compareTo(E o) {
        return 0;
    }

    @Override
    public String getUrl() {
        return this.getLocation().toExternalForm();
    }

    public static class Code extends Edition<Code> {
        public Code(URL url, CodeSigner[] signers, Version version) {
            super(url,signers, version);
        }
    }
    public static class Jar extends Edition<Jar> {
        public Jar(URL url, CodeSigner[] signers,Version version) {
            super(url,signers,version);
        }
    }
    public static class Source extends Edition<Source> {
        public Source(URL url, CodeSigner[] signers, Version version) {
            super(url,signers, version);
        }
    }
    public byte[] defineClass(String datumClassName) {


    }

    public static record Version(String version) {
        public static final Version Aforementioned = new Version(".01"); // can't call it 'this'
    }
}
