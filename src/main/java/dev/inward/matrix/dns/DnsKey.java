package dev.inward.matrix.dns;

import dev.inward.matrix.Terrene;
import dev.inward.matrix.Domain;
import dev.inward.matrix.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.dns.resourceRecord.ResourceRecordType;

public class DnsKey extends ResourceRecord {


    public DnsKey(Domain domain, Terrene terrene) {
        super(domain, ResourceRecordType.dnsKey, terrene);
    }

    @Override
    public int compareTo(ResourceRecord o) {
        return 0;
    }
}
