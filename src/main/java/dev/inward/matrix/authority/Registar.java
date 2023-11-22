package dev.inward.matrix.authority;

import dev.inward.matrix.Clerk;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.fact.Concept;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Registar extends Concept<DNS,Office,Domain,String,Domain,Registar> {

    public Registar(Domain identity) {
        super(identity);
    }

    protected transient final Map<Clerk, Instant> clerksLastUsed = new ConcurrentHashMap<>();
    protected final Map<ResourceRecord, Instant> resourceRecordsLastUpdated = new ConcurrentHashMap<>();
}
