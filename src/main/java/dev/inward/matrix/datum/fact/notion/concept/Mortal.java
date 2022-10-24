package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.matter.report.Report;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Mortal<C extends Concept<C,M>,M extends Mortal<C,M>> extends Agent<C,Identity.Ego, Context.Demarc,M> {

    public Mortal(C concept, ReferenceQueue<C> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(concept, referenceQueue, notionProtectionDomain);
    }
    public void report(Report report) {

    }
}
