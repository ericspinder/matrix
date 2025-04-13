/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

public abstract class ResourceRecordParser<LB extends ResourceRecordLibrarian<LB,K,F,V,M,R,G>,K extends RRKey<LB,K,F,V,M,R,G>,F extends ResourceRecord<LB,K,F,V,M,R,G>,V extends RRView<LB,K,F,V,M,R,G>,M extends RRModel<LB,K,F,V,M,R,G>,R extends RRReference<LB,K,F,V,M,R,G>,G extends RRSteward<LB,K,F,V,M,R,G>> {

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
    protected abstract RRKey.Builder<LB,K,F,V,M,R,G> newRRKeyBuilder();

    public abstract F parse(String[] parts);
}
