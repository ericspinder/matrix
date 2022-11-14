package dev.inward.matrix.fact.notion;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.report.Report;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;
import java.util.UUID;

public class Agent<N extends Notion<N,I,X>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>> extends Representative<N,I,X,A,I,X> {

    protected final NotionProtectionDomain notionProtectionDomain;

    public Agent(N notion, ReferenceQueue<N> referenceQueue, UUID uuid, Specification<>) {
        super(notion, notion.getIdentity(), referenceQueue,uuid, );
        this.notionProtectionDomain = notionProtectionDomain;
    }
    public void report(Report report) {

    }

}
