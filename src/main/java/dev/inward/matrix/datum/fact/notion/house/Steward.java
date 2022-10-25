package dev.inward.matrix.datum.fact.notion.house;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Steward<H extends House<H,P>,P extends Steward<H,P>> extends Agent<H, Identity.Ghost, Context.Ethereal,P> {

    public Steward(Corpus concept, ReferenceQueue<Corpus> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(concept, referenceQueue, notionProtectionDomain);
    }
}
