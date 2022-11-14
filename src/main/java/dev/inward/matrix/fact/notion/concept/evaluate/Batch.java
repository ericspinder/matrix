package dev.inward.matrix.fact.notion.concept.evaluate;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Effect;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Batch extends Effect<Bakery,Evaluate,Batch,Calc,Existent> {

    public Batch(Specification specification, Supplier<Bakery, Evaluate, Batch, Identity.Ego, Context.Demarc, Calc, Existent, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }

}
