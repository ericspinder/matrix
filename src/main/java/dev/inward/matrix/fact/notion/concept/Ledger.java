package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Diplomat;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.notion.Ambassador;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

public interface Ledger<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>, DATUM, D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {

    boolean forRemoval(Envoy<DATUM,D,E,F,I,X,P> envoy);
}
