package dev.inward.matrix.authority.dns;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.Fact;

import java.util.UUID;

public class Question extends Gathering<Scheme.DNS, Library.DNS, Question, UUID,> {

    protected final Domain domain;
    protected final ResourceRecordType type;
    protected final Terrene terrene;

    public Question(Domain domain, ResourceRecordType type, Terrene terrene) {
        this.domain = domain;
        this.type = type;
        this.terrene = terrene;
    }

    public final Domain getDomain() {
        return domain;
    }

    public final ResourceRecordType getType() {
        return type;
    }

    public final Terrene getTerrene() {
        return terrene;
    }

}
