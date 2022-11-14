package dev.inward.matrix.fact.notion.authority;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.matter.messaging.Request;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.domain.ResourceRecord;
import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.notion.interaction.dns.DnsInteraction;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class Authority extends Notion<Authority, Identity.Ghost,Context.Ethereal,> {

    public static final Authority INTERNET_DNS_ROOT = RootAuthority();
    protected Server[] nameservers;
    protected InternetClass[] internetClasses;

    
    public Authority(Identity.Ghost id, InternetClass[] internetClasses) {
        super(id,version, expire);
        this.internetClasses = internetClasses;
    }

    public abstract ResourceRecord[] getResourceRecords(String servername);

    public Server[] getNameservers() {
        return nameservers;
    }

    public void setNameservers(Server[] nameservers) {
        this.nameservers = nameservers;
    }

    private static final Authority RootAuthority() {
        try {
            Authority rootTld = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(null, InternetClass.Legacy)));
            Domain netDomain = new Domain("net", rootTld);
            Authority netTld = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(rootTld, InternetClass.Legacy)));
            Domain netRootServer = new Domain("root-servers", netTld);
            Authority netRootServerAuthority = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(netTld, InternetClass.Legacy)));
            Server[] nameservers = new Server[26];
            nameservers[0] = new Server(new Domain("a",netRootServerAuthority), InetAddress.getByName("198.41.0.4"),InternetClass.Legacy);
            nameservers[1] = new Server(new Domain("a",netRootServerAuthority), InetAddress.getByName("2001:503:ba3e::2:30"),InternetClass.Legacy);
            nameservers[2] = new Server(new Domain("b",netRootServerAuthority), InetAddress.getByName("199.9.14.201"),InternetClass.Legacy);
            nameservers[3] = new Server(new Domain("b",netRootServerAuthority), InetAddress.getByName("2001:500:200::b"),InternetClass.Legacy);
            nameservers[4] = new Server(new Domain("c",netRootServerAuthority), InetAddress.getByName("192.33.4.12"),InternetClass.Legacy);
            nameservers[5] = new Server(new Domain("c",netRootServerAuthority), InetAddress.getByName("2001:500:2::c"),InternetClass.Legacy);
            nameservers[6] = new Server(new Domain("d",netRootServerAuthority), InetAddress.getByName("199.7.91.13"),InternetClass.Legacy);
            nameservers[7] = new Server(new Domain("d",netRootServerAuthority), InetAddress.getByName("2001:500:2d::d"),InternetClass.Legacy);
            nameservers[8] = new Server(new Domain("e",netRootServerAuthority), InetAddress.getByName("192.203.230.10"),InternetClass.Legacy);
            nameservers[9] = new Server(new Domain("e",netRootServerAuthority), InetAddress.getByName("2001:500:a8::e"),InternetClass.Legacy);
            nameservers[10] = new Server(new Domain("f",netRootServerAuthority), InetAddress.getByName("192.5.5.241"),InternetClass.Legacy);
            nameservers[11] = new Server(new Domain("f",netRootServerAuthority), InetAddress.getByName("2001:500:2f::f"),InternetClass.Legacy);
            nameservers[12] = new Server(new Domain("g",netRootServerAuthority), InetAddress.getByName("192.112.36.4"),InternetClass.Legacy);
            nameservers[13] = new Server(new Domain("g",netRootServerAuthority), InetAddress.getByName("2001:500:12::d0d"),InternetClass.Legacy);
            nameservers[14] = new Server(new Domain("h",netRootServerAuthority), InetAddress.getByName("198.97.190.53"),InternetClass.Legacy);
            nameservers[15] = new Server(new Domain("h",netRootServerAuthority), InetAddress.getByName("2001:500:1::53"),InternetClass.Legacy);
            nameservers[16] = new Server(new Domain("i",netRootServerAuthority), InetAddress.getByName("192.36.148.17"),InternetClass.Legacy);
            nameservers[17] = new Server(new Domain("i",netRootServerAuthority), InetAddress.getByName("2001:7fe::53"),InternetClass.Legacy);
            nameservers[18] = new Server(new Domain("j",netRootServerAuthority), InetAddress.getByName("192.58.128.30"),InternetClass.Legacy);
            nameservers[19] = new Server(new Domain("j",netRootServerAuthority), InetAddress.getByName("2001:503:c27::2:30"),InternetClass.Legacy);
            nameservers[20] = new Server(new Domain("k",netRootServerAuthority), InetAddress.getByName("193.0.14.129"),InternetClass.Legacy);
            nameservers[21] = new Server(new Domain("k",netRootServerAuthority), InetAddress.getByName("2001:7fd::1"),InternetClass.Legacy);
            nameservers[22] = new Server(new Domain("l",netRootServerAuthority), InetAddress.getByName("199.7.83.42"),InternetClass.Legacy);
            nameservers[23] = new Server(new Domain("l",netRootServerAuthority), InetAddress.getByName("2001:500:9f::42"),InternetClass.Legacy);
            nameservers[24] = new Server(new Domain("m",netRootServerAuthority), InetAddress.getByName("202.12.27.33"),InternetClass.Legacy);
            nameservers[25] = new Server(new Domain("m",netRootServerAuthority), InetAddress.getByName("2001:dc3::35"),InternetClass.Legacy);
            rootTld.setNameservers(nameservers);
            return rootTld;
        } catch (UnknownHostException e) {
            throw new NotionStartupException(NotionStartupException.Type.NetworkUnavailable_No_Return, Authority.class, Indicia.Focus.Assembly, Indicia.Severity.Exceptional,e);
        }
    }
}
