package dev.inward.matrix.domain;

import java.io.Serializable;

public class TopLevelDomain<TDL extends TopLevelDomain<TDL>> implements Comparable<TDL>, Serializable {

    protected final TopLevelDomain topLevelDomain;
    protected final String tld;
    protected RemoteServer[] remoteServers;


    public TopLevelDomain(String tld,TopLevelDomain topLevelDomain,RemoteServer[] remoteServers) {
        this.tld = tld;
        this.topLevelDomain = topLevelDomain;
        this.remoteServers = remoteServers;
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
    public static final TopLevelDomain COM = new TopLevelDomain("COM", null, RemoteServer.COM_NS_ARRAY);
}
