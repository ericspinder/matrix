package dev.inward.matrix.fact.authoritative.notion.concept.boot;

import crud.Protocol;
import dev.inward.matrix.fact.operational.IntegerDefaultOption;

public final class Boot extends Protocol<Boot> {

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
