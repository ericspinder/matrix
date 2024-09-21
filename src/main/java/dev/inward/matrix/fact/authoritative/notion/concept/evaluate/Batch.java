package dev.inward.matrix.fact.authoritative.notion.concept.evaluate;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.Effect;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Batch extends Effect<Bakery,Evaluate,Batch,Calc,Existent> {

    public Batch(Specification specification, Supplier<Bakery, Evaluate, Batch, Identity.Ego, Context.Demarc, Calc, Existent, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }

}
