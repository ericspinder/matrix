package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.report.Report;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Agent<N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>> extends Representative<N,I,X,A,I,X> {

    protected final NotionProtectionDomain notionProtectionDomain;

    public Agent(N notion, ReferenceQueue<N> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(notion, notion.getId(), referenceQueue);
        this.notionProtectionDomain = notionProtectionDomain;
    }
    public void report(Report report) {

    }

}
