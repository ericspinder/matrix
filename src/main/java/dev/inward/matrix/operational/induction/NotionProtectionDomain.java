package dev.inward.matrix.operational.induction;

import dev.inward.matrix.agent.Edition;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.personality.Personality;

import java.security.ProtectionDomain;

public class NotionProtectionDomain extends ProtectionDomain {

    public NotionProtectionDomain(Edition edition, Personality personality, ClassLoader classloader, Persona[] principals) {
        super(edition, personality, classloader, principals);
    }

    public Edition getEdition() {
        return (Edition) this.getCodeSource();
    }

}
