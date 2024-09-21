package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Terrene;

public abstract class MatrixAuthority extends ResourceRecord<MatrixAuthority> {

    public MatrixAuthority(Domain domain, Terrene terrene) {
        super(domain, ResourceRecordType.MatrixAuthority, terrene);
    }

    @Override
    protected String rData() {
        return null;
    }

}
