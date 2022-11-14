package dev.inward.matrix.resources;

import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.*;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.personality.Persona;
import dev.inward.matrix.personality.Personality;

import java.security.ProtectionDomain;

public class NotionProtectionDomain<Y extends Factory<Y,F,I,X,R>,F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends ProtectionDomain {

    public NotionProtectionDomain(Edition edition, Personality personality,Y industry, Persona[] personas) {
        super(edition, personality, industry, personas);
    }


    public Edition getEdition() {
        return (Edition) this.getCodeSource();
    }

}
