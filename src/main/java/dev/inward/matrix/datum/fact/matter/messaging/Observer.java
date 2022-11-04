package dev.inward.matrix.datum.fact.matter.messaging;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Delegated;

import java.lang.ref.ReferenceQueue;

public class Observer<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Delegated<Studio<M,IS,XS>,M, Scratch.Scheduler<M,IS,XS>, Identity.Ego, Context.Demarc,Scratch<M,IS,XS>, Observer<M,IS,XS>> {

    public Observer(M fact, ReferenceQueue<M> referenceQueue, Scratch<M, IS, XS> bus, Scratch.Scheduler<M, IS, XS> operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
