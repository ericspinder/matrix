package dev.inward.matrix.datum.creation;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.time.Duration;

public abstract class Creation<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P,?,?>,E extends Envoy<?,Creation<F,I,X,P,E>,F,?,I,X,?,P,?,?,E>> extends Datum<Creation<F,I,X,P,E>,F,I,X,P,E> {

    private Duration elapsedTime() {

    }
}
