package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.agent.Startup;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.operational.IntegerOption;

public final class Boot extends Concept<Boot, Root> {

    @IntegerOption.IntegerDefault(IntegerOption.DnsTimeout)

    protected final Startup startup;

    public Boot(Identity.Ego id, Startup startup) {
        super(id);
        this.startup = startup;
    }


    public Startup getStartup() {
        return this.startup;
    }
}
