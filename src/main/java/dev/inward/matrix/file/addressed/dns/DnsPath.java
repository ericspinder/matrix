/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns;

public record DnsPath(DnsLibraryKey dnsLibraryKey, ResourceRecordType type) implements Comparable<DnsPath> {

    public String toString() {
        return "/" + this.dnsLibraryKey.getDomain() + "/" + ((this.type !=null)? this.type.getLabel() + "/":"");
    }

    @Override
    public int compareTo(DnsPath that) {
        int isZero = this.dnsLibraryKey.compareTo(that.dnsLibraryKey);
        if (isZero == 0 && type != null) {
            return this.type.compareTo(that.type);
        }
        return isZero;
    }
}
