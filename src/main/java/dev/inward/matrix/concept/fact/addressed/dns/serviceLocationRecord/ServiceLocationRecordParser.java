/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns.serviceLocationRecord;

import dev.inward.matrix.file.userInfo.record.DnsDirectoryKey;
import dev.inward.matrix.concept.fact.addressed.dns.ResourceRecordParser;
import dev.inward.matrix.concept.fact.addressed.dns.ResourceRecordType;

public class ServiceLocationRecordParser extends ResourceRecordParser<ServiceLocationRecord,ServiceLocationRecordKey,ServiceLocationRecordView,ServiceLocationRecordModel, ServiceLocationRecordReference, ServiceLocationRecordLibrarian> {
    public ServiceLocationRecordParser(DnsDirectoryKey dnsDirectoryKey) {
        super(dnsDirectoryKey);
    }

    @Override
    protected ResourceRecordType expectedDnsPathRecordType() {
        return ResourceRecordType.serviceLocationRecord;
    }

    @Override
    protected ServiceLocationRecordKey.Builder newRRKeyBuilder() {
        return new ServiceLocationRecordKey.Builder();
    }

    @Override
    public ServiceLocationRecord parse(String[] parts) {
        return null;
    }
}
