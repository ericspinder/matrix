package dev.inward.matrix;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.intialized.Functionary;
import dev.inward.matrix.fact.matter.messaging.Maker;
import dev.inward.matrix.fact.matter.messaging.Observer;
import dev.inward.matrix.fact.matter.messaging.Scratch;
import dev.inward.matrix.fact.matter.messaging.Studio;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Scheduler<M extends Maker<M, ?, ?, ?, ?, ?, ?, ?, ?>, IS extends Identity<IS, XS>, XS extends Context<XS>> extends Functionary<Studio<M, IS, XS>, M, Scheduler<M, IS, XS>, Identity.Ego, Context.Demarc, Scratch<M, IS, XS>, Observer<M, IS, XS>> {


    public Scheduler(Specification specification, Supplier<Studio<M, IS, XS>, M, Scheduler<M, IS, XS>, Identity.Ego, Context.Demarc, Scratch<M, IS, XS>, Observer<M, IS, XS>, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
