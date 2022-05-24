package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

public class Gathering {


    public interface Ledger<Y extends Factory<Y,F,O,I,X,B,P,N,A>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,A>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,A>,P extends Diplomat<Y,F,O,I,X,B,P,N,A>,N extends Notion<N,I,X,A>,A extends Ambassador<?,N,?,I,X,?,A,?,?>> {
        boolean forRemoval(Envoy<DATUM,D,E,F,I,X,P,N, A> envoy);
    }
}
