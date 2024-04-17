package dev.inward.matrix.concept.matter.messaging.issuer;

import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;

import java.lang.ref.ReferenceQueue;

public class Imprint extends Representative<Issuer, Identity.Gate, Context.Path,Imprint, Identity.Gate, Context.Path> {
    public Imprint(Issuer issuer, ReferenceQueue referenceQueue, Identity.Gate containerId) {
        super(issuer, referenceQueue, containerId);
    }
}
