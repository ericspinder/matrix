package dev.inward.matrix.matter.maker.issuer;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Imprint extends Representative<Issuer,Identity.SuperEgo,Context.Service,Imprint, Identity.SuperEgo,Context.Service> {
    public Imprint(Issuer issuer, ReferenceQueue referenceQueue, Identity.SuperEgo containerId) {
        super(issuer, referenceQueue, containerId);
    }
}
