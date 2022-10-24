package dev.inward.matrix.resources;

import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.personality.Personality;

import java.security.ProtectionDomain;

public class NotionProtectionDomain<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends ProtectionDomain {

    public NotionProtectionDomain(Edition edition, Personality personality,Y industry, Persona[] personas) {
        super(edition, personality, industry, personas);
    }


    public Edition getEdition() {
        return (Edition) this.getCodeSource();
    }

}
