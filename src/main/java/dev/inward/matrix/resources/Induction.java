package dev.inward.matrix.resources;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.Envoy;
import dev.inward.matrix.rubric.Criterion;
import dev.inward.matrix.rubric.Zone;

import java.util.Map;

public abstract class Induction<Y extends Factory<Y,F,O,I,X,B,R,N,NI,NX,A>,F extends Fact<F,I,X,R,NI,NX>,O extends Operational<Y,F,O,I,X,B,R,N,NI,NX,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>>

    protected final String datumClassName;
    protected final Map<Criterion, Zone[]> criteriaForZones;
    protected final

    protected Induction(String datumClassName,Map<Criterion,Zone[]> criteriaForZones,Specification<F,I,X> specification) {
        this.datumClassName = datumClassName;
        this.criteriaForZones = criteriaForZones;
    }
    public <DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> Class<D> wrapper(String datumClassName) {

    }
    public <DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> V build(DATUM datum,F fact,N notion) {
        ((Factory)this.getClass().getClassLoader()).getEngine().
    }

    public String getDatumClassName() {
        return datumClassName;
    }
    public Map<Criterion,Zone[]> getCriteria(Zone zone) {


}
