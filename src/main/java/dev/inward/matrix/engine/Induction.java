package dev.inward.matrix.engine;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.route.Route;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.Context;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerant;
import dev.inward.matrix.resources.Resource;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Induction<DATUM,S extends Scheme<S,L,PATH,N>,L extends Library<S,L,PATH,N>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<S,L,PATH,ID,I,C>,C extends Concept<S,L,PATH,ID,I,C,N>,N extends Notion<S,L,PATH,N>> {

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