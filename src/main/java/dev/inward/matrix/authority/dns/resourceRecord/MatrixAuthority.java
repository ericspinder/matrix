package dev.inward.matrix.authority.dns.resourceRecord;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;

public abstract class MatrixAuthority extends ResourceRecord<MatrixAuthority> {

    public MatrixAuthority(Domain domain, Terrene terrene) {
        super(domain, ResourceRecordType.MatrixAuthority, terrene);
    }

    @Override
    protected String rData() {
        return null;
    }

}
