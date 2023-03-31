package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.authority.*;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ObservedAuthority extends Authority {

    public static final ObservedAuthority INTERNET_DNS_ROOT = RootAuthority();

    public ObservedAuthority() {
        super(nameservers);
    }

    private static final ObservedAuthority RootAuthority() {
        try {
            ObservedAuthority rootTld = new ObservedAuthority();

            Domain netDomain = new Domain(null,"net");
            Authority netTld = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(netDomain, InternetClass.Earth, Zone.InSituDefault)));
            Domain netRootServer = new Domain("root-servers", netTld);
            Authority netRootServerAuthority = new ObservedAuthority(new Identity.Ghost(new Context.Ethereal(netRootServer, InternetClass.Earth, Zone.InSituDefault)));

            ServerRecord[] nameservers = new ServerRecord[26];
            Domain name_server_a = new Domain("a",netRootServerAuthority);
            nameservers[0] = new ServerRecord(name_server_a, InetAddress.getByName("198.41.0.4"),InternetClass.Earth);
            nameservers[1] = new ServerRecord(name_server_a, InetAddress.getByName("2001:503:ba3e::2:30"),InternetClass.Earth);

            Domain name_server_b = new Domain("b",netRootServerAuthority);
            nameservers[2] = new ServerRecord(name_server_b, InetAddress.getByName("199.9.14.201"),InternetClass.Earth);
            nameservers[3] = new ServerRecord(name_server_b, InetAddress.getByName("2001:500:200::b"),InternetClass.Earth);

            Domain name_server_c = new Domain("c",netRootServerAuthority);
            nameservers[4] = new ServerRecord(name_server_c, InetAddress.getByName("192.33.4.12"),InternetClass.Earth);
            nameservers[5] = new ServerRecord(name_server_c, InetAddress.getByName("2001:500:2::c"),InternetClass.Earth);

            Domain name_server_d = new Domain("d",netRootServerAuthority);
            nameservers[6] = new ServerRecord(name_server_d, InetAddress.getByName("199.7.91.13"),InternetClass.Earth);
            nameservers[7] = new ServerRecord(name_server_d, InetAddress.getByName("2001:500:2d::d"),InternetClass.Earth);

            Domain name_server_e = new Domain("e",netRootServerAuthority);
            nameservers[8] = new ServerRecord(name_server_e, InetAddress.getByName("192.203.230.10"),InternetClass.Earth);
            nameservers[9] = new ServerRecord(name_server_e, InetAddress.getByName("2001:500:a8::e"),InternetClass.Earth);

            Domain name_server_f = new Domain("f",netRootServerAuthority);
            nameservers[10] = new ServerRecord(name_server_f, InetAddress.getByName("192.5.5.241"),InternetClass.Earth);
            nameservers[11] = new ServerRecord(name_server_f, InetAddress.getByName("2001:500:2f::f"),InternetClass.Earth);

            Domain name_server_g = new Domain("g",netRootServerAuthority);
            nameservers[12] = new ServerRecord(name_server_g, InetAddress.getByName("192.112.36.4"),InternetClass.Earth);
            nameservers[13] = new ServerRecord(name_server_g, InetAddress.getByName("2001:500:12::d0d"),InternetClass.Earth);

            Domain name_server_h = new Domain("h",netRootServerAuthority);
            nameservers[14] = new ServerRecord(name_server_h, InetAddress.getByName("198.97.190.53"),InternetClass.Earth);
            nameservers[15] = new ServerRecord(name_server_h, InetAddress.getByName("2001:500:1::53"),InternetClass.Earth);

            Domain name_server_i = new Domain("i",netRootServerAuthority);
            nameservers[16] = new ServerRecord(name_server_i, InetAddress.getByName("192.36.148.17"),InternetClass.Earth);
            nameservers[17] = new ServerRecord(name_server_i, InetAddress.getByName("2001:7fe::53"),InternetClass.Earth);

            Domain name_server_j = new Domain("j",netRootServerAuthority);
            nameservers[18] = new ServerRecord(name_server_j, InetAddress.getByName("192.58.128.30"),InternetClass.Earth);
            nameservers[19] = new ServerRecord(name_server_j, InetAddress.getByName("2001:503:c27::2:30"),InternetClass.Earth);

            Domain name_server_k = new Domain("k",netRootServerAuthority);
            nameservers[20] = new ServerRecord(name_server_k, InetAddress.getByName("193.0.14.129"),InternetClass.Earth);
            nameservers[21] = new ServerRecord(name_server_k, InetAddress.getByName("2001:7fd::1"),InternetClass.Earth);

            Domain name_server_l = new Domain("l",netRootServerAuthority);
            nameservers[22] = new ServerRecord(name_server_l, InetAddress.getByName("199.7.83.42"),InternetClass.Earth);
            nameservers[23] = new ServerRecord(name_server_l, InetAddress.getByName("2001:500:9f::42"),InternetClass.Earth);

            Domain name_server_m = new Domain("m",netRootServerAuthority);
            nameservers[24] = new ServerRecord(name_server_m, InetAddress.getByName("202.12.27.33"),InternetClass.Earth);
            nameservers[25] = new ServerRecord(name_server_m, InetAddress.getByName("2001:dc3::35"),InternetClass.Earth);

            rootTld.setNameservers(InternetClass.Earth,nameservers);
            return rootTld;
        } catch (UnknownHostException e) {
            throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return, Authority.class, Indicia.Focus.Assembly, Indicia.Severity.Exceptional,e);
        }
    }

    @Override
    public ResourceRecord[] getResourceRecords(String servername, ResourceRecordType[] resourceRecordTypes) {
        return new ResourceRecord[0];
    }
}
