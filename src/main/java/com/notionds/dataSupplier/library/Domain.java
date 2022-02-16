package com.notionds.dataSupplier.library;

import java.io.Serializable;
import java.util.Arrays;

public abstract class Domain implements Comparable<Domain>, Serializable {

    protected final TopLevelDomain tld;
    protected final String[] parts;

    public Domain(TopLevelDomain tld, String[] parts) {
        this.tld = tld;
        this.parts = parts;
    }
    public TopLevelDomain getTld() {
        return this.tld;
    }
    public String[] getParts() {
        return this.parts;
    }
    @Override
    public int compareTo(Domain that) {
        int isZero = this.tld.compareTo(that.tld);
        if (isZero == 0) {
            for(int i = 0; i < this.parts.length; i++) {
                int isZeroPart = this.parts[i].compareToIgnoreCase(that.parts[i]);
                if (isZeroPart != 0) {
                       return isZeroPart;
                }
            }
            if (this.parts.length < that.parts.length) {
                return -1;
            }
        }
        return 0;
    }

    public final class COM extends Domain {

        public COM(String[] parts) {
            super(TopLevelDomain.COM, parts);
        }
    }
}
