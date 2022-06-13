package dev.inward.matrix.datum.creation;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.time.Duration;
import java.time.Instant;

public class Creation<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> extends Datum<Instant,Creation<F,I,X,P>,CreationEnvoy<F,I,X,P>,F,I,X,P> {

    private Duration elapsedTime() {
        return Duration.between(this.tracking.getEnvoy().get(),Instant.now());
    }
}
