package dev.inward.matrix.datum.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Book;

public class Scratch<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Book<Studio<M,IS,XS>,M,Scheduler<M,IS,XS>, Identity.Ego, Context.JVM,Scratch<M,IS,XS>, Observer<M,IS,XS>> {

    public Scratch(Scheduler<M, IS, XS> operational) {
        super(operational);
    }
}
