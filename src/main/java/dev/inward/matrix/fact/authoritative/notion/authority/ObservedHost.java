package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.Host;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.authority.*;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;
import dev.inward.matrix.authority.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Indicia;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ObservedHost extends Host {

    public static final ObservedHost INTERNET_DNS_ROOT = RootAuthority();

    public ObservedHost() {
        super(nameservers);
    }

    private static final ObservedHost RootAuthority() {
        try {
            ObservedHost rootTld = new ObservedHost();

            Domain netDomain = new Domain(null,"net");
            Host netTld = new ObservedHost(new Identity.Ghost(new Context.Ethereal(netDomain, Terrene.Earth, Zone.InSituDefault)));
            Domain netRootServer = new Domain("root-servers", netTld);
            Host netRootServerHost = new ObservedHost(new Identity.Ghost(new Context.Ethereal(netRootServer, Terrene.Earth, Zone.InSituDefault)));

            ServerRecord[] nameservers = new ServerRecord[26];
            Domain name_server_a = new Domain("a", netRootServerHost);
            nameservers[0] = new ServerRecord(name_server_a, InetAddress.getByName("198.41.0.4"), Terrene.Earth);
            nameservers[1] = new ServerRecord(name_server_a, InetAddress.getByName("2001:503:ba3e::2:30"), Terrene.Earth);

            Domain name_server_b = new Domain("b", netRootServerHost);
            nameservers[2] = new ServerRecord(name_server_b, InetAddress.getByName("199.9.14.201"), Terrene.Earth);
            nameservers[3] = new ServerRecord(name_server_b, InetAddress.getByName("2001:500:200::b"), Terrene.Earth);

            Domain name_server_c = new Domain("c", netRootServerHost);
            nameservers[4] = new ServerRecord(name_server_c, InetAddress.getByName("192.33.4.12"), Terrene.Earth);
            nameservers[5] = new ServerRecord(name_server_c, InetAddress.getByName("2001:500:2::c"), Terrene.Earth);

            Domain name_server_d = new Domain("d", netRootServerHost);
            nameservers[6] = new ServerRecord(name_server_d, InetAddress.getByName("199.7.91.13"), Terrene.Earth);
            nameservers[7] = new ServerRecord(name_server_d, InetAddress.getByName("2001:500:2d::d"), Terrene.Earth);

            Domain name_server_e = new Domain("e", netRootServerHost);
            nameservers[8] = new ServerRecord(name_server_e, InetAddress.getByName("192.203.230.10"), Terrene.Earth);
            nameservers[9] = new ServerRecord(name_server_e, InetAddress.getByName("2001:500:a8::e"), Terrene.Earth);

            Domain name_server_f = new Domain("f", netRootServerHost);
            nameservers[10] = new ServerRecord(name_server_f, InetAddress.getByName("192.5.5.241"), Terrene.Earth);
            nameservers[11] = new ServerRecord(name_server_f, InetAddress.getByName("2001:500:2f::f"), Terrene.Earth);

            Domain name_server_g = new Domain("g", netRootServerHost);
            nameservers[12] = new ServerRecord(name_server_g, InetAddress.getByName("192.112.36.4"), Terrene.Earth);
            nameservers[13] = new ServerRecord(name_server_g, InetAddress.getByName("2001:500:12::d0d"), Terrene.Earth);

            Domain name_server_h = new Domain("h", netRootServerHost);
            nameservers[14] = new ServerRecord(name_server_h, InetAddress.getByName("198.97.190.53"), Terrene.Earth);
            nameservers[15] = new ServerRecord(name_server_h, InetAddress.getByName("2001:500:1::53"), Terrene.Earth);

            Domain name_server_i = new Domain("i", netRootServerHost);
            nameservers[16] = new ServerRecord(name_server_i, InetAddress.getByName("192.36.148.17"), Terrene.Earth);
            nameservers[17] = new ServerRecord(name_server_i, InetAddress.getByName("2001:7fe::53"), Terrene.Earth);

            Domain name_server_j = new Domain("j", netRootServerHost);
            nameservers[18] = new ServerRecord(name_server_j, InetAddress.getByName("192.58.128.30"), Terrene.Earth);
            nameservers[19] = new ServerRecord(name_server_j, InetAddress.getByName("2001:503:c27::2:30"), Terrene.Earth);

            Domain name_server_k = new Domain("k", netRootServerHost);
            nameservers[20] = new ServerRecord(name_server_k, InetAddress.getByName("193.0.14.129"), Terrene.Earth);
            nameservers[21] = new ServerRecord(name_server_k, InetAddress.getByName("2001:7fd::1"), Terrene.Earth);

            Domain name_server_l = new Domain("l", netRootServerHost);
            nameservers[22] = new ServerRecord(name_server_l, InetAddress.getByName("199.7.83.42"), Terrene.Earth);
            nameservers[23] = new ServerRecord(name_server_l, InetAddress.getByName("2001:500:9f::42"), Terrene.Earth);

            Domain name_server_m = new Domain("m", netRootServerHost);
            nameservers[24] = new ServerRecord(name_server_m, InetAddress.getByName("202.12.27.33"), Terrene.Earth);
            nameservers[25] = new ServerRecord(name_server_m, InetAddress.getByName("2001:dc3::35"), Terrene.Earth);

            rootTld.setNameservers(Terrene.Earth,nameservers);
            return rootTld;
        } catch (UnknownHostException e) {
            throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return, Host.class, Indicia.Focus.Assembly, Indicia.Severity.Exceptional,e);
        }
    }

    @Override
    public ResourceRecord[] getResourceRecords(String servername, ResourceRecordType[] resourceRecordTypes) {
        return new ResourceRecord[0];
    }
}
