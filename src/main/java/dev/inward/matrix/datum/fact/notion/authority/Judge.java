package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.induction.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Judge extends Agent<Authority,Identity.SuperEgo,Context.Service,Judge> {

    public Judge(Authority authority, ReferenceQueue<Authority> referenceQueue, Identity.SuperEgo containerId, NotionProtectionDomain notionProtectionDomain) {
        super(authority, referenceQueue, containerId, notionProtectionDomain);
    }
}
