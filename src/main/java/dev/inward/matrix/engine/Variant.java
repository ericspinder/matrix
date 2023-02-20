package dev.inward.matrix.engine;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.InternetClass;

import java.security.CodeSigner;
import java.security.CodeSource;

public class Variant extends CodeSource implements Meta_I {

    protected final Domain domain;
    protected final String label;
    protected final String description;

    public Variant(Domain domain, CodeSigner[] codeSigners, InternetClass internetClass, String label, String description) {
        super(domain.getURL(), codeSigners);
        this.domain = domain;
        this.internetClass = internetClass;
        this.label = label;
        this.description = description;
    }

    @Override
    public final String getLabel() {
        return label;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    public final InternetClass getInternetClass() {
        return internetClass;
    }


    public static final Variant aforementioned = new Variant();

}
