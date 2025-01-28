package dev.inward.matrix.engine;

import dev.inward.matrix.Pathway;
import dev.inward.matrix.Specification;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Variant extends CodeSource {

    protected final Specification specification;
    public Variant(URL url, CodeSigner[] codeSigners, String hash, Specification specification) {
        super(url, codeSigners);
        this.specification = specification;

    }

}