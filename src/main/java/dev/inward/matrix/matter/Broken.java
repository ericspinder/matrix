package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.time.Instant;
import java.util.UUID;

public class Broken<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>,F extends Fact<F,I,X,R>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R>,B extends Broken<DATUM,D,V,F,I,X,R,B>> extends Matter<I,X,B> {

    protected final D child;
    public Broken(UUID uuid, I id, Instant createInstant, Indicia indicia, D child) {
        super(uuid, id, createInstant, indicia);
        this.child = child;
    }

}
