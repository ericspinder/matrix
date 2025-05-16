/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.serverRecord;

import dev.inward.matrix.file.resource.record.DnsDirectoryKey;
import dev.inward.matrix.file.resource.record.ResourceRecordType;

public class Ip6ServerRecordParser extends ServerRecordParser<Ip6ServerRecord,Ip6ServerRecordKey,Ip6ServerRecordView,Ip6ServerRecordModel,Ip6ServerRecordReference,Ip6ServerRecordLibrarian> {
    public Ip6ServerRecordParser(DnsDirectoryKey dnsDirectoryKey) {
        super(dnsDirectoryKey);
    }

    @Override
    protected ResourceRecordType expectedDnsPathRecordType() {
        return ResourceRecordType.ipV6Address;
    }

    @Override
    protected Ip6ServerRecordKey.Builder newRRKeyBuilder() {
        return new Ip6ServerRecordKey.Builder();
    }

    @Override
    public Ip6ServerRecord parse(String[] parts) {
        return null;
    }
}
