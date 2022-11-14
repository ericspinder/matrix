package dev.inward.matrix.fact.notion.concept.boot;

import dev.inward.matrix.fact.notion.house.ziggurat.Startup;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Concept;
import dev.inward.matrix.fact.operational.IntegerOption;

public final class Boot extends Concept<Boot> {

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
