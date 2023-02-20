package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.Context;

import java.lang.ref.ReferenceQueue;

public class Regulated<,P extends Context.Platform<P>> extends Representative<Regulator<ID,P>, Identity.SuperEgo, Context.Path,Regulated<ID,P>,ID,P> {

    public Regulated(Regulator<ID, P> idpRegulator, ID containerId, ReferenceQueue<Regulator<ID, P>> referenceQueue) {
        super(idpRegulator, containerId, referenceQueue);
    }
}
