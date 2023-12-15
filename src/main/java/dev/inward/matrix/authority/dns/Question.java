package dev.inward.matrix.authority.dns;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;

public class Question {

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
