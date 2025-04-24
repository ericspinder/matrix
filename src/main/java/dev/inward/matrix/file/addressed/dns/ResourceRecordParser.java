/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

public abstract class ResourceRecordParser<K extends RRKey<K,F,V,M,R,B>,F extends ResourceRecord<K,F,V,M,R,B>,V extends RRView<K,F,V,M,R,B>,M extends RRModel<K,F,V,M,R,B>,R extends RRReference<K,F,V,M,R,B>,B extends RRLibrarian<K,F,V,M,R,B>> {

    protected final DnsDirectoryKey dnsDirectoryKey;

    public ResourceRecordParser(DnsDirectoryKey dnsDirectoryKey) {
        if (dnsDirectoryKey.directoryPath.type().equals(expectedDnsPathRecordType())) {
            this.dnsDirectoryKey = dnsDirectoryKey;
        }
        else {
            throw new RuntimeException("Wrong ResourceRecordType found in DnsPath, expected = " + expectedDnsPathRecordType() + ", found = " + dnsDirectoryKey.directoryPath.type());
        }
    }
    protected abstract ResourceRecordType expectedDnsPathRecordType();
    public DnsDirectoryKey getDnsDirectoryKey() {
        return dnsDirectoryKey;
    }
    protected abstract RRKey.Builder<K,F,V,M,R,B> newRRKeyBuilder();

    public abstract F parse(String[] parts);
}
