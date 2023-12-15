package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.Scheduler;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.intialized.Book;
import dev.inward.matrix.Context;

public class Scratch<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Book<Studio<M,IS,XS>,M, Scheduler<M,IS,XS>, Identity.Ego, Context.Demarc,Scratch<M,IS,XS>, Observer<M,IS,XS>> {

    public Scratch(Scheduler<M, IS, XS> operational) {
        super(operational);
    }

}
