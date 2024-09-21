package dev.inward.matrix.engine;

import dev.inward.matrix.Pathway;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Specification;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Variant<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>> extends CodeSource {

    protected final Specification specification;
    public Variant(URL url, CodeSigner[] codeSigners, String hash, Specification specification) {
        super(url, codeSigners);
        this.specification = specification;

    }

}