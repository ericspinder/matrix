package dev.inward.matrix.authority.dns;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;

public class Question implements Comparable<Question> {

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

    @Override
    public int compareTo(Question that) {
        int isZero = this.domain.compareTo(that.domain);
        if (isZero == 0) {
            isZero = this.type.compareTo(that.type);
            if (isZero == 0) {
                return this.terrene.compareTo(that.terrene);
            }
        }
        return isZero;
    }
}
