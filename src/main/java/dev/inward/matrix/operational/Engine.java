package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.notion.concept.Context;

import java.time.Instant;

public class Engine<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {

    protected final O operational;
    public final Instant createInstant = Instant.now();

    public Engine(O operational) {
        this.operational = operational;
    }

    public O getOperational() {
        return operational;
    }
}
