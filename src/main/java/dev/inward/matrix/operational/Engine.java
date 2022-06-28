package dev.inward.matrix.operational;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.library.ProtectionDomainStorage;
import dev.inward.matrix.meta.Standard;
import dev.inward.matrix.rubric.Envoy;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class Engine<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {

    protected final O operational;
    public final Instant createInstant = Instant.now();

    public Engine(O operational) {
        this.operational = operational;
    }
    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>> Resource<Y,DATUM,D,E,F,O,I,X,B,P> get(Standard<DATUM,F,I,X> standard) {
        return (Resource<Y,DATUM,D,E,F,O,I,X,B,P>)super.get(standard);
    }

    public O getOperational() {
        return operational;
    }
}
