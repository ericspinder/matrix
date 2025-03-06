/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

public abstract class ResourceRecordParser<K extends RRKey<K,F,R,A,RESOURCE,M>,F extends ResourceRecord<K,F,R,A,RESOURCE,M>,R extends RRReference<K,F,R,A,RESOURCE,M>,A extends RRAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends RRResource<K,F,R,A,RESOURCE,M>,M extends RRModel<K,F,R,A,RESOURCE,M>> {

    protected final DnsDirectoryKey dnsDirectoryKey;

    public ResourceRecordParser(DnsDirectoryKey dnsDirectoryKey) {
        if (dnsDirectoryKey.filePath.type().equals(expectedDnsPathRecordType())) {
            this.dnsDirectoryKey = dnsDirectoryKey;
        }
        else {
            throw new RuntimeException("Wrong ResourceRecordType found in DnsPath, expected = " + expectedDnsPathRecordType() + ", found = " + dnsDirectoryKey.filePath.type());
        }
    }
    protected abstract ResourceRecordType expectedDnsPathRecordType();
    public DnsDirectoryKey getDnsDirectoryKey() {
        return dnsDirectoryKey;
    }
    protected abstract RRKey.Builder<K,F,R,A,RESOURCE,M> newRRKeyBuilder();

    public abstract F parse(String[] parts);
}
