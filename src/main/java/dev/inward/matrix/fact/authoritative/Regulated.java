package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.Representitive;
import dev.inward.matrix.Context;

import java.lang.ref.ReferenceQueue;

public class Regulated<,P extends Context.Platform<P>> extends Representitive<Regulator<ID,P>, Identity.Gate, Context.Path,Regulated<ID,P>,ID,P> {

    public Regulated(Regulator<ID, P> idpRegulator, ID containerId, ReferenceQueue<Regulator<ID, P>> referenceQueue) {
        super(idpRegulator, containerId, referenceQueue);
    }
}
