package dev.inward.matrix.fact.authoritative.notion.house;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.authority.Registrar;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.personality.Persona;

public abstract class House<S extends Scheme<S,L>,L extends Library<S,L>,H extends House<S,L,H,P>,P extends Persona<S,L,P>> implements Comparable<H> {

    protected final Identity.Ego<S,L,P> ego;
    protected final Zone zone;
    protected ResourceRecord<S,L,?>[] resourceRecords;
    protected final Registrar registrar;

    public House(Identity.Ego<S,L,P> ego, Zone zone, Registrar registrar) {
        this.ego = ego;
        this.zone = zone;
        this.registrar = registrar;
    }

    @Override
    public int compareTo(H that) {
        return this.ego.compareTo(that.ego);
    }
}
