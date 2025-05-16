/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.startOfAuthority;

import dev.inward.matrix.file.resource.record.DnsDirectoryKey;
import dev.inward.matrix.file.resource.record.ResourceRecordParser;
import dev.inward.matrix.file.resource.record.ResourceRecordType;

public class StartOfAuthorityParser extends ResourceRecordParser<StartOfAuthority,StartOfAuthorityKey,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference,StartOfAuthorityLibrarian> {

    public StartOfAuthorityParser(DnsDirectoryKey dnsDirectoryKey) {
        super(dnsDirectoryKey);
    }

    @Override
    protected ResourceRecordType expectedDnsPathRecordType() {
        return ResourceRecordType.StartOfAuthority;
    }

    @Override
    protected StartOfAuthorityKey.Builder newRRKeyBuilder() {
        return new StartOfAuthorityKey.Builder();
    }

    @Override
    public StartOfAuthority parse(String[] parts) {
        return null;
    }
}
