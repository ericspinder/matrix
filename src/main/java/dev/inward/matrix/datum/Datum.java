package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.io.Serializable;

public abstract class Datum<DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>,E extends Envoy<?,DATUM,D,F,?,I,X,?,P,NP,PP,E>> {

    protected Tracking<?,DATUM,D,F,?,I,X,?,P,NP,PP,E> tracking = new Tracking(this);

    public final DATUM getDatum() {
        return this.tracking.getEnvoy().get();
    }
}
