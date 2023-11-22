package dev.inward.matrix.fact.datum.creation;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;

import java.time.Duration;
import java.time.Instant;

public class Creation<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Model<?,F,?,I,X,?,P>> extends Datum<Instant,Creation<F,I,X,P>,CreationEnvoy<F,I,X,P>,F,I,X,P> {


    private Duration elapsedTime() {
        return Duration.between(this.tracking.getEnvoy().get(),Instant.now());
    }
}
