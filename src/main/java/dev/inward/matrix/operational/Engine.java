package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.factory.Factory;

import java.time.Instant;

public class Engine<Y extends Factory<Y,F,O,I,X,B,R,IC,XC>,F extends Fact<F,I,X,R,IC,XC>,O extends Operational<Y,F,O,I,X,B,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R,IC,XC>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> {

    protected final O operational;
    public final Instant createInstant = Instant.now();

    public Engine(O operational) {
        this.operational = operational;
    }

    public O getOperational() {
        return operational;
    }
}
