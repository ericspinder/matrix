package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

public class Mechanical extends Effect<Assembly, Corpus,Mechanical,Sandbox,Prophet> {

    public Mechanical(Options options, Supplier<Assembly, Corpus, Mechanical, Identity.Ego, Context.JVM, Sandbox, Prophet,Assembly,Corpus,Mechanical,Sandbox,Prophet> supplier) {
        super(options, supplier);
    }
}
