package dev.inward.matrix.concept.matter.messaging.issuer;

import dev.inward.matrix.Representitive;
import dev.inward.matrix.Context;

import java.lang.ref.ReferenceQueue;

public class Imprint extends Representitive<Issuer, Identity.Gate, Context.Path,Imprint, Identity.Gate, Context.Path> {
    public Imprint(Issuer issuer, ReferenceQueue referenceQueue, Identity.Gate containerId) {
        super(issuer, referenceQueue, containerId);
    }
}
