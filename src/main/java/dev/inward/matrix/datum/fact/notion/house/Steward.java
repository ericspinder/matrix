package dev.inward.matrix.datum.fact.notion.house;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public abstract class Steward<H extends House<H,P>,P extends Steward<H,P>> extends Agent<H, Identity.Ghost, Context.Ethereal,P> {

    public Steward(H notion, ReferenceQueue<H> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(notion, referenceQueue, notionProtectionDomain);
    }
}
