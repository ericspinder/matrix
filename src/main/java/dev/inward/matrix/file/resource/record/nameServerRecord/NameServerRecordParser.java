/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.nameServerRecord;

import dev.inward.matrix.file.resource.record.DnsDirectoryKey;
import dev.inward.matrix.file.resource.record.ResourceRecordParser;
import dev.inward.matrix.file.resource.record.ResourceRecordType;

public class NameServerRecordParser extends ResourceRecordParser<NameServerRecord,NameServerRecordKey,NameServerRecordView,NameServerRecordModel,NameServerRecordReference,NameServerRecordLibrarian> {
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
