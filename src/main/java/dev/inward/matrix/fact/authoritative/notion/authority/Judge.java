package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.authority.Authority;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Judge extends Agent<Authority,Identity.SuperEgo, Context.Path,Judge> {

    public Judge(Authority authority, ReferenceQueue<Authority> referenceQueue, Identity.SuperEgo containerId, MatrixProtectionDomain matrixProtectionDomain) {
        super(authority, referenceQueue, containerId, matrixProtectionDomain);
    }
}
