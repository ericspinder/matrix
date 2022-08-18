package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.induction.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Agent<N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>> extends Representative<N,I,X,A,I,X> {

    protected final NotionProtectionDomain notionProtectionDomain;
    public Agent(N notion, ReferenceQueue<N> referenceQueue, I containerId, NotionProtectionDomain notionProtectionDomain) {
        super(notion, referenceQueue, containerId);
        this.notionProtectionDomain = notionProtectionDomain;
    }
}
