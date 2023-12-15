package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Scheduler;
import dev.inward.matrix.fact.intialized.Delegated;
import dev.inward.matrix.Context;

import java.lang.ref.ReferenceQueue;

public class Observer<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Delegated<Studio<M,IS,XS>,M, Scheduler<M,IS,XS>, Identity.Ego, Context.Demarc,Scratch<M,IS,XS>, Observer<M,IS,XS>> {

    public Observer(M fact, ReferenceQueue<M> referenceQueue, Scratch<M, IS, XS> bus, Scheduler<M, IS, XS> operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
