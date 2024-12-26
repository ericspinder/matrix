package dev.inward.matrix.engine;

import dev.inward.matrix.*;
import dev.inward.matrix.Concept;
import dev.inward.matrix.fact.authoritative.notion.Agent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Induction<DATUM,PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,D,ID,I,C>,C extends Concept<PATH,D,ID,I,C,R>,R extends Representative<PATH,D,ID,I,C,R> {

    protected final DatumVisitor<DATUM> datumVisitor;
    protected final Resource<DATUM,S,L,PATH,ID,I,C,N> resource;

    public Induction(@Nonnull Resource<DATUM,S,L,PATH,ID,I,C,N> resource,@Nullable DatumVisitor<DATUM> datumVisitor) {
        this.resource = resource;
        if (datumVisitor != null) {
            datumVisitor = new DatumVisitor<DATUM>();
        }
    }
    public V engage(DATUM datum,R representative) {

    }

    public Resource<DATUM> getResource() {
        return resource;
    }
}