package dev.inward.matrix.domain;

import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.edition.Edition;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
    public static RootDomain RootDomainInstance = new RootDomain(getRootServerList());

    private static final Server[] getRootServerList() {
        try {
            InetAddress aServer4Address = InetAddress.getByName("198.41.0.4");
            Factory factory = ((Factory) aServer4Address.getClass().getClassLoader());
            Server[] servers = new Server[13];
            Ethereal Ethereal (edition,boolean production, Domain domain)
            servers[0] = new Server("a.root-servers.net", "198.41.0.4", "2001:503:ba3e::2:30");
            servers[1] = new Server("b.root-servers.net", "199.9.14.201", "2001:500:200::b");
            servers[2] = new Server("c.root-servers.net", "192.33.4.12", "2001:500:2::c");
            servers[3] = new Server("d.root-servers.net", "199.7.91.13", "2001:500:2d::d");
            servers[4] = new Server("e.root-servers.net", "192.203.230.10", "2001:500:a8::e");
            servers[5] = new Server("f.root-servers.net", "192.5.5.241", "2001:500:2f::f");
            servers[6] = new Server("g.root-servers.net", "192.112.36.4", "2001:500:12::d0d");
            servers[7] = new Server("h.root-servers.net", "198.97.190.53", "2001:500:1::53");
            servers[8] = new Server("i.root-servers.net", "192.36.148.17", "2001:7fe::53");
            servers[9] = new Server("j.root-servers.net", "192.58.128.30", "2001:503:c27::2:30");
            servers[10] = new Server("k.root-servers.net", "193.0.14.129", "2001:7fd::1");
            servers[11] = new Server("l.root-servers.net", "199.7.83.42", "2001:500:9f::42");
            servers[12] = new Server("m.root-servers.net", "202.12.27.33", "2001:dc3::35");
            return servers;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    private static class RootDomain extends TopLevelDomain<RootDomain> {

        public RootDomain(Server[] servers) {
            super(".", null, servers);
        }
    }
}
