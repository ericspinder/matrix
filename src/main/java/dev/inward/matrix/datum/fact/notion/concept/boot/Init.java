package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Boot;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Root;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Ziggurat;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Init extends Effect<Boot, Ziggurat,Init,Structure, Root> {

    private final String args;

    public Init(Specification specification, Supplier<Boot, dev.inward.matrix.datum.fact.notion.concept.boot.Boot, Init, Identity.Ego, Context.Demarc, Structure, Root, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain, String args) {
        super(specification, supplier, protectionDomain);
        this.args = args;
    }


    public String getArgs() {
        return this.args;
    }
}
