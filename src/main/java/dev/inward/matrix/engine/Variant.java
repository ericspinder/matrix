package dev.inward.matrix.engine;

import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.InternetClass;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Variant extends CodeSource {

    protected final Domain domain;
    protected final InternetClass internetClass;

    public Variant(URL url, CodeSigner[] codeSigners, Domain domain, InternetClass internetClass) {
        super(url, codeSigners);
        this.domain = domain;
        this.internetClass = internetClass;
    }

    public final InternetClass getInternetClass() {
        return internetClass;
    }


    public static final Variant aforementioned = new Variant();

}
