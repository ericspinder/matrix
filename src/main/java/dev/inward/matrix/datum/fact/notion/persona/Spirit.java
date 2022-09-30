package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Spirit extends Agent<Persona,Identity.SuperEgo,Context.Service,Spirit> {

    public Spirit(Persona persona, ReferenceQueue<Persona> referenceQueue, Identity.SuperEgo containerId, NotionProtectionDomain notionProtectionDomain) {
        super(persona, referenceQueue, containerId, notionProtectionDomain);
    }
}
