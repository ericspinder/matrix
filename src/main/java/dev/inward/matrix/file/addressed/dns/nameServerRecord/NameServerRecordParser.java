/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.nameServerRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.ResourceRecordParser;
import dev.inward.matrix.file.addressed.dns.ResourceRecordType;

public class NameServerRecordParser extends ResourceRecordParser<NameServerRecordKey,NameServerRecord,NameServerRecordReference,NameServerRecordAttributes,NameServerRecordResource,NameServerRecordModel> {
    public NameServerRecordParser(DnsDirectoryKey dnsDirectoryKey) {
        super(dnsDirectoryKey);
    }

    @Override
    protected ResourceRecordType expectedDnsPathRecordType() {
        return ResourceRecordType.nameServer;
    }

    @Override
    protected NameServerRecordKey.Builder newRRKeyBuilder() {
        return null;
    }

    @Override
    public NameServerRecord parse(String[] parts) {
        return null;
    }
}
