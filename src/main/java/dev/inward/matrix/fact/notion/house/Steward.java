package dev.inward.matrix.fact.notion.house;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public abstract class Steward<H extends House<H,P>,P extends Steward<H,P>> extends Agent<H, Identity.Ghost, Context.Ethereal,P> {

    public Steward(H notion, ReferenceQueue<H> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(notion, referenceQueue, notionProtectionDomain);
    }
}
