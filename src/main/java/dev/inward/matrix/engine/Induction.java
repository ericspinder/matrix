package dev.inward.matrix.engine;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Envoy;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.resources.Resources;

public abstract class Induction<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>,F extends Fact<F,I,X,R,NI,NX>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R,N,NI,NX,A,U>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,U extends Route<F,I,X,B,R,N,NI,NX,A,U>,S extends Resources<F,I,X,R,NI,NX>> {

    protected final String s;
    protected DatumVisitor datumVisitor;

    public Class<D> wrapper() {
         = ((Factory)getClass().getClassLoader()).getEngine().;
        factory.

    }

    /**
     *
     * @param envoy
     * @param representative
     * @param bus
     * @return the envoy to be saved in the datum or null if it is to be discarded. Returning the parameter envoy might be expected later.
     */
    public abstract V engage(V envoy,R representative,B bus,U route);

}