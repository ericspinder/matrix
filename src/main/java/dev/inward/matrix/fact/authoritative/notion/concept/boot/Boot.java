package dev.inward.matrix.fact.authoritative.notion.concept.boot;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.concept.Concept;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat.Startup;
import dev.inward.matrix.fact.operational.IntegerDefaultOption;

public final class Boot extends Concept<Boot> {

    @IntegerDefaultOption.IntegerDefault(IntegerDefaultOption.DnsTimeout)

    protected final Startup startup;

    public Boot(Identity.Ego id, Startup startup) {
        super(id);
        this.startup = startup;
    }


    public Startup getStartup() {
        return this.startup;
    }
}
