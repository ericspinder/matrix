package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.matter.messaging.Request;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.ResourceRecord;
import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.datum.fact.matter.Indicia;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class Authority extends Notion<Authority, Identity.Ghost,Context.Ethereal> {

    public static final Authority INTERNET_DNS_ROOT = RootAuthority();
    protected Server[] nameservers;
    protected char[] testCodes;

    public Authority(Identity.Ghost id, char[] testCodes) {
        super(id);
        this.testCodes = testCodes;
    }
    public Authority(Identity.Ghost id) {
        super(id);
        this.testCodes = null;
    }

    public ResourceRecord[] getResourceRecord(Request request) {
        if (request.)
    }

    public Server[] getNameservers() {
        return nameservers;
    }

    public void setNameservers(Server[] nameservers) {
        this.nameservers = nameservers;
    }

    private static final Authority RootAuthority() {
        try {
            Authority rootTld = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(null,Context.Production)));
            Domain netDomain = new Domain("net", rootTld);
            Authority netTld = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(rootTld, Context.Production)));
            Domain netRootServer = new Domain("root-servers", netTld);
            Authority netRootServerAuthority = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(netTld, Context.Production)));
            Server[] nameservers = new Server[26];
            nameservers[0] = new Server(new Domain("a",netRootServerAuthority), InetAddress.getByName("198.41.0.4"));
            nameservers[1] = new Server(new Domain("a",netRootServerAuthority), InetAddress.getByName("2001:503:ba3e::2:30"));
            nameservers[2] = new Server(new Domain("b",netRootServerAuthority), InetAddress.getByName("199.9.14.201"));
            nameservers[3] = new Server(new Domain("b",netRootServerAuthority), InetAddress.getByName("2001:500:200::b"));
            nameservers[4] = new Server(new Domain("c",netRootServerAuthority), InetAddress.getByName("192.33.4.12"));
            nameservers[5] = new Server(new Domain("c",netRootServerAuthority), InetAddress.getByName("2001:500:2::c"));
            nameservers[6] = new Server(new Domain("d",netRootServerAuthority), InetAddress.getByName("199.7.91.13"));
            nameservers[7] = new Server(new Domain("d",netRootServerAuthority), InetAddress.getByName("2001:500:2d::d"));
            nameservers[8] = new Server(new Domain("e",netRootServerAuthority), InetAddress.getByName("192.203.230.10"));
            nameservers[9] = new Server(new Domain("e",netRootServerAuthority), InetAddress.getByName("2001:500:a8::e"));
            nameservers[10] = new Server(new Domain("f",netRootServerAuthority), InetAddress.getByName("192.5.5.241"));
            nameservers[11] = new Server(new Domain("f",netRootServerAuthority), InetAddress.getByName("2001:500:2f::f"));
            nameservers[12] = new Server(new Domain("g",netRootServerAuthority), InetAddress.getByName("192.112.36.4"));
            nameservers[13] = new Server(new Domain("g",netRootServerAuthority), InetAddress.getByName("2001:500:12::d0d"));
            nameservers[14] = new Server(new Domain("h",netRootServerAuthority), InetAddress.getByName("198.97.190.53"));
            nameservers[15] = new Server(new Domain("h",netRootServerAuthority), InetAddress.getByName("2001:500:1::53"));
            nameservers[16] = new Server(new Domain("i",netRootServerAuthority), InetAddress.getByName("192.36.148.17"));
            nameservers[17] = new Server(new Domain("i",netRootServerAuthority), InetAddress.getByName("2001:7fe::53"));
            nameservers[18] = new Server(new Domain("j",netRootServerAuthority), InetAddress.getByName("192.58.128.30"));
            nameservers[19] = new Server(new Domain("j",netRootServerAuthority), InetAddress.getByName("2001:503:c27::2:30"));
            nameservers[20] = new Server(new Domain("k",netRootServerAuthority), InetAddress.getByName("193.0.14.129"));
            nameservers[21] = new Server(new Domain("k",netRootServerAuthority), InetAddress.getByName("2001:7fd::1"));
            nameservers[22] = new Server(new Domain("l",netRootServerAuthority), InetAddress.getByName("199.7.83.42"));
            nameservers[23] = new Server(new Domain("l",netRootServerAuthority), InetAddress.getByName("2001:500:9f::42"));
            nameservers[24] = new Server(new Domain("m",netRootServerAuthority), InetAddress.getByName("202.12.27.33"));
            nameservers[25] = new Server(new Domain("m",netRootServerAuthority), InetAddress.getByName("2001:dc3::35"));
            rootTld.setNameservers(nameservers);
            return rootTld;
        } catch (UnknownHostException e) {
            throw new NotionStartupException(NotionStartupException.Type.NetworkUnavailable_No_Return, Authority.class, Indicia.Focus.Assembly, Indicia.Severity.Exceptional,e);
        }
    }
}
