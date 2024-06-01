package dev.inward.matrix.authority.dns.resourceRecord;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.fact.authoritative.notion.concept.Ledger;

import java.util.Map;

public abstract class Zone extends ResourceRecord<Zone> {

    protected final String serial;
    protected final boolean authoritative;
    protected final boolean cache;
    protected final Map<ResourceRecord<?>, Ledger>
    public static class Full extends Zone {


    }
    public static class Partial extends Zone {

    }
    public Zone(Domain domain, Terrene terrene) {
        super(domain, , terrene);
    }

    @Override
    protected String rData() {
        return null;
    }
}
