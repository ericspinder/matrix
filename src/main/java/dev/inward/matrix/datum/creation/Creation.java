package dev.inward.matrix.datum.creation;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.time.Duration;
import java.time.Instant;

public abstract class Creation<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Ambassador<?,NP,?,I,X,?,PP>> extends Datum<Instant,Creation<F,I,X,P,NP,PP>,F,I,X,P,NP,PP,Prime<?,F,?,I,X,?,P,NP,PP>> {

    private Duration elapsedTime() {
        return Duration.between(this.tracking.getDatum(),Instant.now());
    }
}
