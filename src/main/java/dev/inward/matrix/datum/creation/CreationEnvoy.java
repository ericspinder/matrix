package dev.inward.matrix.datum.creation;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Model;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.Envoy;

import java.lang.ref.ReferenceQueue;
import java.time.Instant;

public class CreationEnvoy<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Model<?,F,?,I,X,?,P>> extends Envoy<Instant,Creation<F,I,X,P>,CreationEnvoy<F,I,X,P>,F,I,X,P> {

    public CreationEnvoy(Instant datum, ReferenceQueue<Instant> referenceQueue) {
        super(datum, referenceQueue);
    }

}
