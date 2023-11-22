package dev.inward.matrix.authority.dns;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;

public class DnsKey extends ResourceRecord {


    public DnsKey(Domain domain, Terrene terrene) {
        super(domain, ResourceRecordType.dnsKey, terrene);
    }

    @Override
    public int compareTo(ResourceRecord o) {
        return 0;
    }
}
