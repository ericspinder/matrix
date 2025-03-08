/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.ResourceRecordType;

public class Ip4ServerRecordParser extends ServerRecordParser<Ip4ServerRecordKey,Ip4ServerRecord,Ip4ServerRecordReference,Ip4ServerRecordAttributes,Ip4ServerRecordResource,Ip4ServerRecordModel> {
    public Ip4ServerRecordParser(DnsDirectoryKey dnsDirectoryKey) {
        super(dnsDirectoryKey);
    }

    @Override
    protected ResourceRecordType expectedDnsPathRecordType() {
        return ResourceRecordType.ipV4Address;
    }

    @Override
    protected Ip4ServerRecordKey.Builder newRRKeyBuilder() {
        return new Ip4ServerRecordKey.Builder();
    }

    @Override
    public Ip4ServerRecord parse(String[] parts) {
        return null;
    }
}
