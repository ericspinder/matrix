package dev.inward.matrix.datum.creation;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.meta.time.Instant;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class CreationEnvoy<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Envoy<Instant,Creation<F,I,X,P>,Envoy.NoOp<Instant,Creation<F,I,X,P>,>,F,I,X,P> {
    public CreationEnvoy(Creation datum, ReferenceQueue<Creation> referenceQueue) {
        super(datum, referenceQueue);
    }
}
