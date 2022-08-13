package dev.inward.matrix.datum.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Functionary;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.induction.Supplier;

import java.security.ProtectionDomain;

public class Scheduler<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Functionary<Studio<M,IS,XS>,M,Scheduler<M,IS,XS>, Identity.Ego, Context.JVM,Scratch<M,IS,XS>, Observer<M,IS,XS>> {


    public Scheduler(Specification specification, Supplier<Studio<M, IS, XS>, M, Scheduler<M, IS, XS>, Identity.Ego, Context.JVM, Scratch<M, IS, XS>, Observer<M, IS, XS>, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
