package dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.Effect;
import dev.inward.matrix.fact.authoritative.notion.concept.boot.Structure;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Init extends Effect<Boot, Ziggurat,Init, Structure, Root> {

    private final String args;

    public Init(Specification specification, Supplier<Boot, dev.inward.matrix.fact.authoritative.notion.concept.boot.Boot, Init, Identity.Ego, Context.Demarc, Structure, Root, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain, String args) {
        super(specification, supplier, protectionDomain);
        this.args = args;
    }


    public String getArgs() {
        return this.args;
    }
}
