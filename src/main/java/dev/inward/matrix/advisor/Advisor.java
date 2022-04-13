package dev.inward.matrix.advisor;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Gathering;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.aggregation.Participants;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.advisor.advice.Advice;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.matter.sanction.Sanction;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Advisor<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>,A extends Advisor<Y,D,F,O,I,X,B,P,E,A>> implements Comparable<A>, Serializable {

    protected Map<Advice<Y,D,F,O,I,X,B,P,?,?,?>, Participants<Y,D,F,O,I,X,B,P,?,?>> adviceWithParticipants = new ConcurrentHashMap();

    public <D extends Datum<D,F,I,X,P,?>,T extends Throwable, S extends Sanction> void handle(T t, D datum) {
        //new Breaker<D,F,I,X,P,?>();

    }


    public final <L extends Gathering.Ledger<Y,D,F,O,I,X,B,P>> void add(Advice<Y,D,F,O,I,X,B,P,?,L,?> advice) {
        adviceWithParticipants.put(advice,advice.supply());
    }
    public final void removeAdvisor(Advice adviceToRemove) {
    }

}
