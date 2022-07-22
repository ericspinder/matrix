package dev.inward.matrix.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Batch extends Effect<Bakery,Evaluate,Batch,Calc,Existent> {

    public Batch(Specification specification, Supplier<Bakery, Evaluate, Batch, Identity.Ego, Context.JVM, Calc, Existent, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }

}
