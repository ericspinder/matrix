package dev.inward.matrix.domain;

import java.io.Serializable;

public class TopLevelDomain<TDL extends TopLevelDomain<TDL>> implements Comparable<TDL>, Serializable {

    protected final TopLevelDomain topLevelDomain;
    protected final String tld;
    protected Server[] servers;


    public TopLevelDomain(String tld, TopLevelDomain topLevelDomain, Server[] servers) {
        this.tld = tld;
        this.topLevelDomain = topLevelDomain;
        this.servers = servers;
    }

    @Override
    public int compareTo(TDL that) {
        if(this.topLevelDomain != null) {
            int isZero = this.topLevelDomain.compareTo(that.topLevelDomain);
            if (isZero == 0) {
                return this.tld.compareTo(that.tld);
            }
            return isZero;
        }
        return this.tld.compareTo(that.tld);
    }
    @Override
    public String toString() {
        if(this.topLevelDomain != null) {
            return this.tld + this.topLevelDomain;
        }
        return this.tld;
    }
    public static final TopLevelDomain COM = new TopLevelDomain("COM", null, Server.COM_NS_ARRAY);
}
