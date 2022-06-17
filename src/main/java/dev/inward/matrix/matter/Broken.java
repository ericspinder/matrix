package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;

import java.time.Instant;
import java.util.UUID;

public class Broken<D extends Datum<?,D,F,?,I,X,?,P>,F extends Fact<?,F,?,I,X,?,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>,M extends Broken<D,F,I,X,P,M>> extends Matter<I,X,M> {

    protected final D child;
    public Broken(UUID uuid, I id, Instant createInstant, Topic topic, D child) {
        super(uuid, id, createInstant, topic);
        this.child = child;
    }

}
