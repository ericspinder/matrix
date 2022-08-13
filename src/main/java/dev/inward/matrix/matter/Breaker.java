package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;

import java.time.Instant;
import java.util.UUID;

public class Breaker<D extends Datum<?,D,F,?,I,X,?,P>,F extends Fact<?,F,?,I,X,?,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>,E extends Throwable> extends Broken<D,F,I,X,P,Breaker<D,F,I,X,P,E>> {

    protected final E breaker;

    public Breaker(UUID uuid, I id, Instant createDateTime, Indicia indicia, D caller, E breaker) {
        super(uuid,id, createDateTime, indicia, caller);
        this.breaker = breaker;
    }

}
