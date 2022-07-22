package dev.inward.matrix.fact.notion.concept.boot;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Init extends Effect<BootLoader,Boot,Init,Structure,Root> {

    private final String args;

    public Init(Specification specification, Supplier<BootLoader, Boot, Init, Identity.Ego, Context.JVM, Structure, Root, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain, String args) {
        super(specification, supplier, protectionDomain);
        this.args = args;
    }


    public String getArgs() {
        return this.args;
    }
}
