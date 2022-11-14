package dev.inward.matrix.fact.notion.person;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.personality.Persona;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Spirit extends Agent<Person,Identity.SuperEgo,Context.Service,Spirit> {


    public Spirit(Persona notion, ReferenceQueue<Persona> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(notion, referenceQueue, notionProtectionDomain);
    }
}
