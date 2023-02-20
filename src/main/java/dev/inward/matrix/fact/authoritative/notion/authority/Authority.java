package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.domain.*;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Authoritative;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.Context;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Authority<A extends Authority<A>>  {

    public static final ObservedAuthority INTERNET_DNS_ROOT = RootAuthority();

    protected final InternetClass internetClass;

    protected Map<Server[],> nameservers = new ConcurrentHashMap<>();

    
    public Authority(InternetClass internetClass) {
        this.internetClass = internetClass;
    }

    public abstract ResourceRecord[] getResourceRecords(String servername, ResourceRecordType[] resourceRecordTypes);


    public void setNameservers(InternetClass internetClass, Server[] nameservers) {
        this.nameservers.put(internetClass, nameservers);
    }

    private static final ObservedAuthority RootAuthority() {
        try {
            ObservedAuthority rootTld = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(null, InternetClass.Legacy, Zone.InSitu)));
            Domain netDomain = new Domain("net", rootTld);
            Authority netTld = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(netDomain, InternetClass.Legacy,Zone.InSitu)));
            Domain netRootServer = new Domain("root-servers", netTld);
            Authority netRootServerAuthority = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(netRootServer, InternetClass.Legacy,Zone.InSitu)));

            Server[] nameservers = new Server[26];
            Domain name_server_a = new Domain("a",netRootServerAuthority);
            nameservers[0] = new Server(name_server_a, InetAddress.getByName("198.41.0.4"),InternetClass.Legacy);
            nameservers[1] = new Server(name_server_a, InetAddress.getByName("2001:503:ba3e::2:30"),InternetClass.Legacy);

            Domain name_server_b = new Domain("b",netRootServerAuthority);
            nameservers[2] = new Server(name_server_b, InetAddress.getByName("199.9.14.201"),InternetClass.Legacy);
            nameservers[3] = new Server(name_server_b, InetAddress.getByName("2001:500:200::b"),InternetClass.Legacy);

            Domain name_server_c = new Domain("c",netRootServerAuthority);
            nameservers[4] = new Server(name_server_c, InetAddress.getByName("192.33.4.12"),InternetClass.Legacy);
            nameservers[5] = new Server(name_server_c, InetAddress.getByName("2001:500:2::c"),InternetClass.Legacy);

            Domain name_server_d = new Domain("d",netRootServerAuthority);
            nameservers[6] = new Server(name_server_d, InetAddress.getByName("199.7.91.13"),InternetClass.Legacy);
            nameservers[7] = new Server(name_server_d, InetAddress.getByName("2001:500:2d::d"),InternetClass.Legacy);

            Domain name_server_e = new Domain("e",netRootServerAuthority);
            nameservers[8] = new Server(name_server_e, InetAddress.getByName("192.203.230.10"),InternetClass.Legacy);
            nameservers[9] = new Server(name_server_e, InetAddress.getByName("2001:500:a8::e"),InternetClass.Legacy);

            Domain name_server_f = new Domain("f",netRootServerAuthority);
            nameservers[10] = new Server(name_server_f, InetAddress.getByName("192.5.5.241"),InternetClass.Legacy);
            nameservers[11] = new Server(name_server_f, InetAddress.getByName("2001:500:2f::f"),InternetClass.Legacy);

            Domain name_server_g = new Domain("g",netRootServerAuthority);
            nameservers[12] = new Server(name_server_g, InetAddress.getByName("192.112.36.4"),InternetClass.Legacy);
            nameservers[13] = new Server(name_server_g, InetAddress.getByName("2001:500:12::d0d"),InternetClass.Legacy);

            Domain name_server_h = new Domain("h",netRootServerAuthority);
            nameservers[14] = new Server(name_server_h, InetAddress.getByName("198.97.190.53"),InternetClass.Legacy);
            nameservers[15] = new Server(name_server_h, InetAddress.getByName("2001:500:1::53"),InternetClass.Legacy);

            Domain name_server_i = new Domain("i",netRootServerAuthority);
            nameservers[16] = new Server(name_server_i, InetAddress.getByName("192.36.148.17"),InternetClass.Legacy);
            nameservers[17] = new Server(name_server_i, InetAddress.getByName("2001:7fe::53"),InternetClass.Legacy);

            Domain name_server_j = new Domain("j",netRootServerAuthority);
            nameservers[18] = new Server(name_server_j, InetAddress.getByName("192.58.128.30"),InternetClass.Legacy);
            nameservers[19] = new Server(name_server_j, InetAddress.getByName("2001:503:c27::2:30"),InternetClass.Legacy);

            Domain name_server_k = new Domain("k",netRootServerAuthority);
            nameservers[20] = new Server(name_server_k, InetAddress.getByName("193.0.14.129"),InternetClass.Legacy);
            nameservers[21] = new Server(name_server_k, InetAddress.getByName("2001:7fd::1"),InternetClass.Legacy);

            Domain name_server_l = new Domain("l",netRootServerAuthority);
            nameservers[22] = new Server(name_server_l, InetAddress.getByName("199.7.83.42"),InternetClass.Legacy);
            nameservers[23] = new Server(name_server_l, InetAddress.getByName("2001:500:9f::42"),InternetClass.Legacy);

            Domain name_server_m = new Domain("m",netRootServerAuthority);
            nameservers[24] = new Server(name_server_m, InetAddress.getByName("202.12.27.33"),InternetClass.Legacy);
            nameservers[25] = new Server(name_server_m, InetAddress.getByName("2001:dc3::35"),InternetClass.Legacy);

            rootTld.setNameservers(InternetClass.Legacy,nameservers);
            return rootTld;
        } catch (UnknownHostException e) {
            throw new NotionStartupException(NotionStartupException.Type.NetworkUnavailable_No_Return, Authority.class, Indicia.Focus.Assembly, Indicia.Severity.Exceptional,e);
        }
    }
}
