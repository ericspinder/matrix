package dev.inward.matrix.fact.notion.concept.corpus;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Mechanical extends Effect<Assembly, Corpus,Mechanical,Sandbox,Prophet> {

    public Mechanical(Specification specification, Supplier<Assembly, Corpus, Mechanical, Identity.Ego, Context.JVM, Sandbox, Prophet, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
