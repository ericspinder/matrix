package dev.inward.matrix.datum.fact.matter.messaging;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.datum.fact.intialized.Functionary;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Book;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Scratch<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Book<Studio<M,IS,XS>,M, Scratch.Scheduler<M,IS,XS>, Identity.Ego, Context.Demarc,Scratch<M,IS,XS>, Observer<M,IS,XS>> {

    public Scratch(Scheduler<M, IS, XS> operational) {
        super(operational);
    }

    public static class Scheduler<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Functionary<Studio<M,IS,XS>,M, Scheduler<M,IS,XS>, Identity.Ego, Context.Demarc,Scratch<M,IS,XS>, Observer<M,IS,XS>> {


        public Scheduler(Specification specification, Supplier<Studio<M, IS, XS>, M, Scheduler<M, IS, XS>, Identity.Ego, Context.Demarc, Scratch<M, IS, XS>, Observer<M, IS, XS>, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
            super(specification, supplier, protectionDomain);
        }
    }
}
