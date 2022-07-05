package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

public class Init extends Effect<BootLoader,Boot,Init,Structure,Root> {

    private final String args;

    public Init(Specification specification, Supplier<BootLoader, Boot, Init, Identity.Ego, Context.JVM, Structure, Root,BootLoader,Boot,Init,Structure,Root> supplier, String args) {
        super(specification, supplier);
        this.args = args;
    }


    public String getArgs() {
        return this.args;
    }
}
