package dev.inward.matrix.resources;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

public abstract class Induction<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>,NI extends Identity<NI,NX>,NX extends Context<NX>>  {

    protected final String datumClassName;

    protected Induction(String datumClassName) {
        this.datumClassName = datumClassName;
    }

    public <DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> V buildEnvoy(DATUM datum,NI notionIdentity) {
//        ((Factory)this.getClass().getClassLoader()).
        return null;
    }

    public String getDatumClassName() {
        return datumClassName;
    }
}
