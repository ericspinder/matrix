/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.terrene;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.concept.file.addressed.dns.serverRecord.Ip4ServerRecord;
import dev.inward.matrix.concept.file.addressed.dns.serverRecord.Ip4ServerRecordKey;
import dev.inward.matrix.concept.file.addressed.dns.serverRecord.ServerRecord;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Earth extends Terrene {

    protected Earth() {
        super("IN", "earth");
    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return null;
    }
    protected Domain createDomain(String domainName, ServerRecord<?,?,?,?,?,?>... serverRecords) {
        Domain domain = new Domain(this, domainName);
        Ip4ServerRecordKey ip4ServerRecordKey = new Ip4ServerRecordKey(domain,);
    }
    public final List<Domain> getRoots {
        List<Domain> roots = new ArrayList<>();
        Domain com_a = new Domain(this,"com.a");
        URI uri = URI.create("a.com");

        com_a.addNameServer(new Ip4ServerRecord(new Ip4ServerRecordKey(uri,)com_a, InetAddress.getByName("198.41.0.4"), Terrene.Earth) {
        }, );
        Domain com_b = new Domain(this,"com.b");
        Domain com_c = new Domain(this,"com.c");
        Domain com_d = new Domain(this,"com.d");
        Domain com_e = new Domain(this,"com.e");
        Domain com_f = new Domain(this,"com.f");
        Domain com_g = new Domain(this,"com.g");
        Domain com_h = new Domain(this, "com.h");
        Domain com_i = new Domain(this,"com.i");
        Domain com_j = new Domain(this, "com.j");
        Domain com_k = new Domain(this,"com.k");
        Domain com_l = new Domain(this,"com.l");
        Domain com_m = new Domain(this, "com.m");

//        private final List<ServerRecord> serverRecords;
//
//        public EarthRoots() {
//            try {
//                ServerRecord[] EARTH_ROOTS = new ServerRecord[]{
//                        new ServerRecord(com_a, InetAddress.getByName("198.41.0.4"), Terrene.Earth),
//                        new ServerRecord(com_a, InetAddress.getByName("2001:503:ba3e::2:30"), Terrene.Earth),
//                        new ServerRecord(com_b, InetAddress.getByName("199.9.14.201"), Terrene.Earth),
//                        new ServerRecord(com_b, InetAddress.getByName("2001:500:200::b"), Terrene.Earth),
//                        new ServerRecord(com_c, InetAddress.getByName("192.33.4.12"), Terrene.Earth),
//                        new ServerRecord(com_c, InetAddress.getByName("2001:500:2::c"), Terrene.Earth),
//                        new ServerRecord(com_d, InetAddress.getByName("199.7.91.13"), Terrene.Earth),
//                        new ServerRecord(com_d, InetAddress.getByName("2001:500:2d::d"), Terrene.Earth),
//                        new ServerRecord(com_e, InetAddress.getByName("192.203.230.10"), Terrene.Earth),
//                        new ServerRecord(com_e, InetAddress.getByName("2001:500:a8::e"), Terrene.Earth),
//                        new ServerRecord(com_f, InetAddress.getByName("192.5.5.241"), Terrene.Earth),
//                        new ServerRecord(com_f, InetAddress.getByName("2001:500:2f::f"), Terrene.Earth),
//                        new ServerRecord(com_g, InetAddress.getByName("192.112.36.4"), Terrene.Earth),
//                        new ServerRecord(com_g, InetAddress.getByName("2001:500:12::d0d"), Terrene.Earth),
//                        new ServerRecord(com_h, InetAddress.getByName("198.97.190.53"), Terrene.Earth),
//                        new ServerRecord(com_h, InetAddress.getByName("2001:500:1::53"), Terrene.Earth),
//                        new ServerRecord(com_i, InetAddress.getByName("192.36.148.17"), Terrene.Earth),
//                        new ServerRecord(com_i, InetAddress.getByName("2001:7fe::53"), Terrene.Earth),
//                        new ServerRecord(com_j, InetAddress.getByName("192.58.128.30"), Terrene.Earth),
//                        new ServerRecord(com_j, InetAddress.getByName("2001:503:c27::2:30"), Terrene.Earth),
//                        new ServerRecord(com_k, InetAddress.getByName("193.0.14.129"), Terrene.Earth),
//                        new ServerRecord(com_k, InetAddress.getByName("2001:7fd::1"), Terrene.Earth),
//                        new ServerRecord(com_l, InetAddress.getByName("199.7.83.42"), Terrene.Earth),
//                        new ServerRecord(com_l, InetAddress.getByName("2001:500:9f::42"), Terrene.Earth),
//                        new ServerRecord(com_m, InetAddress.getByName("202.12.27.33"), Terrene.Earth),
//                        new ServerRecord(com_m, InetAddress.getByName("2001:dc3::35"), Terrene.Earth)
//                };
//                ImmutableList.Builder<ServerRecord> builder = ImmutableList.builder();
//                builder.add(EARTH_ROOTS);
//                serverRecords = ImmutableList.<ServerRecord>builder().build();
//            } catch (UnknownHostException unknownHostException) {
//                throw new MatrixException(MatrixException.Type.UnknownHost, "EarthRoots", IndicaKey.Focus.Assembly, Matter.Severity.Exceptional, unknownHostException);
//            }
//        }
    }
}
