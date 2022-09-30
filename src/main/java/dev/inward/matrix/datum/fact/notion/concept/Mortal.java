package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Mortal<C extends Concept<C,M>,M extends Mortal<C,M>> extends Agent<C,Identity.Ego, Context.Ethereal,M> {


    public Mortal(C notion, ReferenceQueue<C> referenceQueue, Identity.Ego containerId, NotionProtectionDomain notionProtectionDomain) {
        super(notion, referenceQueue, containerId, notionProtectionDomain);
    }
}
