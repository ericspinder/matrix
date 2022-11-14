package dev.inward.matrix.fact.matter.sanction;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Regulated<ID extends Identity.Id<ID,P>,P extends Context.Platform<P>> extends Representative<Regulator<ID,P>, Identity.SuperEgo,Context.Service,Regulated<ID,P>,ID,P> {

    public Regulated(Regulator<ID, P> idpRegulator, ID containerId, ReferenceQueue<Regulator<ID, P>> referenceQueue) {
        super(idpRegulator, containerId, referenceQueue);
    }
}
