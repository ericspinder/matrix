package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Spirit extends Agent<Persona,Identity.SuperEgo,Context.Service,Spirit> {


    public Spirit(Persona notion, ReferenceQueue<Persona> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(notion, referenceQueue, notionProtectionDomain);
    }
}
