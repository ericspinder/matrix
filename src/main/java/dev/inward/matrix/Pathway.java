package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Question;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.fact.Fact;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

public abstract class Pathway<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>, PATHWAY extends Pathway<S,L,PATH,PATHWAY>> implements Comparable<PATHWAY> {

    public abstract L getLibrary();
    protected final PATH path;

    public Pathway(PATH path) {
        this.path = path;
    }
    public PATH getPath() {
        return path;
    }
}
