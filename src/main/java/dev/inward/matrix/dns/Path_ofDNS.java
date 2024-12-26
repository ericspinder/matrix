package dev.inward.matrix.dns;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.dns.resourceRecord.ResourceRecordType;

public class Path_ofDNS implements Comparable<Path_ofDNS> {

    protected final Terrene terrene;
    protected final Domain domain;
    protected final ResourceRecordType type;

    public Path_ofDNS(Terrene terrene, Domain domain, ResourceRecordType type) {
        this.terrene = terrene;
        this.domain = domain;
        this.type = type;
    }

    @Override
    public int compareTo(Path_ofDNS that) {
        int isZero = this.terrene.compareTo(that.terrene);
        if (isZero == 0) {
            isZero = this.domain.compareTo(that.domain);
            if (isZero == 0) {
                return this.type.compareTo(that.type);
            }
        }
        return isZero;
    }
}
