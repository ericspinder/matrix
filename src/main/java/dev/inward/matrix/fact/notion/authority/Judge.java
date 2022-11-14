package dev.inward.matrix.fact.notion.authority;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Judge extends Agent<Authority,Identity.SuperEgo,Context.Service,Judge> {

    public Judge(Authority authority, ReferenceQueue<Authority> referenceQueue, Identity.SuperEgo containerId, NotionProtectionDomain notionProtectionDomain) {
        super(authority, referenceQueue, containerId, notionProtectionDomain);
    }
}
