/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns;

import dev.inward.matrix.Meta_I;
import org.jetbrains.annotations.NotNull;

public abstract class DnsPath implements Comparable<DnsPath> {

    public enum Type implements Meta_I {
        domains,
        ip4Records,
        ip6Records,
        IPSECRecords;

        @Override
        public String getLabel() {
            return "";
        }

        @Override
        public String getDescription() {
            return "";
        }
    }
    protected final String domain_part;
    protected final ResourceRecordType resourceRecordType;
    public DnsPath(String domain_part, ResourceRecordType resourceRecordType) {
        this.domain_part = domain_part;
        this.resourceRecordType = resourceRecordType;
    }

    public String getDomain_part() {
        return domain_part;
    }
    public ResourceRecordType getResourceRecordType() {
        return resourceRecordType;
    }

    @Override
    public int compareTo(@NotNull DnsPath o) {
        int isZero = this.domain_part.compareTo(o.domain_part);
        if (isZero == 0) {
            return this.resourceRecordType.compareTo(o.resourceRecordType);
        }
        return isZero;
    }
}
