/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

public abstract class ResourceRecordParser<F extends ResourceRecord<F,K,V,M,R,B>,K extends RRKey<F,K,V,M,R,B>,V extends RRView<F,K,V,M,R,B>,M extends RRModel<F,K,V,M,R,B>,R extends RRReference<F,K,V,M,R,B>,B extends RRLibrarian<F,K,V,M,R,B>> {

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
    protected abstract RRKey.Builder<F,K,V,M,R,B> newRRKeyBuilder();

    public abstract F parse(String[] parts);
}
