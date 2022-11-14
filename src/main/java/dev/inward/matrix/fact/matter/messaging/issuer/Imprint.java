package dev.inward.matrix.fact.matter.messaging.issuer;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Imprint extends Representative<Issuer,Identity.SuperEgo,Context.Service,Imprint, Identity.SuperEgo,Context.Service> {
    public Imprint(Issuer issuer, ReferenceQueue referenceQueue, Identity.SuperEgo containerId) {
        super(issuer, referenceQueue, containerId);
    }
}
