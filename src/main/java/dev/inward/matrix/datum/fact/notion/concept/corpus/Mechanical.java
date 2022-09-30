package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Mechanical extends Effect<Assembly, Corpus,Mechanical,Sandbox,Prophet> {

    public Mechanical(Specification specification, Supplier<Assembly, Corpus, Mechanical, Identity.Ego, Context.Ethereal, Sandbox, Prophet, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
