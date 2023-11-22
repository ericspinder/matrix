package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.Host;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Judge extends Agent<Host, Identity.Gate, Context.Path,Judge> {

    public Judge(Host host, ReferenceQueue<Host> referenceQueue, Identity.Gate containerId, MatrixProtectionDomain matrixProtectionDomain) {
        super(host, referenceQueue, containerId, matrixProtectionDomain);
    }
}
