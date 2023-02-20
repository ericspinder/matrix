package dev.inward.matrix.fact.matter.messaging.issuer;

import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

import java.lang.ref.ReferenceQueue;

public class Imprint extends Representative<Issuer,Identity.SuperEgo, Context.Path,Imprint, Identity.SuperEgo, Context.Path> {
    public Imprint(Issuer issuer, ReferenceQueue referenceQueue, Identity.SuperEgo containerId) {
        super(issuer, referenceQueue, containerId);
    }
}
