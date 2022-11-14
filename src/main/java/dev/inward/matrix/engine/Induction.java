package dev.inward.matrix.engine;

import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;
import dev.inward.matrix.resources.Resource;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Induction<DATUM,V extends Envoy<DATUM,V>,F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,U extends Route<F,I,X,B,R,N,NI,NX,A,U,P,M,T>,P extends Phenomenon<M,P,T>,M extends Matter<M,I,X>,T extends Tolerances<M,T>> {

    protected final DatumVisitor<DATUM> datumVisitor;
    protected final Resource<DATUM> resource;

    public Induction(@Nonnull Resource<DATUM> resource,@Nullable DatumVisitor<DATUM> datumVisitor) {
        this.resource = resource;
        if (datumVisitor != null) {

        }
    }
    public V engage(DATUM datum,R representative) {

    }

    public Resource<DATUM> getResource() {
        return resource;
    }
}