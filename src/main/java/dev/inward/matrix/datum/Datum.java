package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

public abstract class Datum<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,D,F,?,I,X,?,P,?,?,E>> {

    protected Tracking<?,D,F,?,I,X,?,P,?,?,E> tracking = new Tracking(this);

}
