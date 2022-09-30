package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;

import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.resources.Induction;
import dev.inward.matrix.resources.Supplier;
import dev.inward.matrix.rubric.Zone;
import dev.inward.matrix.standard.Standard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Operational<Y extends Factory<Y,F,O,I,X,B,R,N,NI,NX,A>,F extends Fact<F,I,X,R,NI,NX>,O extends Operational<Y,F,O,I,X,B,R,N,NI,NX,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>> {

    protected final Zone zone;
    protected final Supplier<Y,F,O,I,X,B,R,N,NI,NX,A> supplier;
    protected final Specification<F,I,X> specification;
    protected final Map<String, Induction> inductionMap = new HashMap<>();

    public Operational(Zone zone, Specification<F,I,X> specification, Supplier<Y,F,O,I,X,B,R,N,NI,NX,A> supplier) {
        this.zone = zone;
        this.specification = specification;
        this.supplier = supplier;
        for (Standard standard: specification.getStandards(zone)) {
            try {

            }
            inductionMap.put(standard.getDatumClassName(),)
        }
    }

    public Supplier<Y,F,O,I,X,B,R,N,NI,NX,A> supplier() {
        return this.supplier;
    }

    public Specification<F,I,X> specification() {
        return this.specification;
    }

    public Induction[] inductions() {
        return this.inductions;
    }
    public Settle settle(Matter<?,I,X> matter) {

    }

    /**
     * Who do you report to based on Matter with an identity of NI?
     * @param matter
     */
    public void report(Matter<?, NI, NX> matter, Map<String,String> details) {
        Server server = this.specification.indiciaServerMap.get(matter.getIndica());

    }
}
