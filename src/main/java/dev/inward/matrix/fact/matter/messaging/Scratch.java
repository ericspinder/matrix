package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.intialized.Book;
import dev.inward.matrix.fact.intialized.Functionary;
import dev.inward.matrix.fact.Context;
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
