package dev.inward.matrix.authority.dns;

import com.google.common.collect.ImmutableList;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.fact.matter.Indicia;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Terrene implements Comparable<Terrene> {
    public static final Terrene Earth = new Terrene("IN", "////","Earth");
    public static final Terrene Luna = new Terrene("LN","//~","Luna");
    public static final Terrene Helios = new Terrene("HS", "//!","Helios");
    public static final Terrene Chaosnet = new Terrene("CS", "//@","Chaosnet");
    public static final Terrene Aforementioned = new Terrene('\u0000', "//~","Aforementioned");

    private static final Map<Terrene, Director<?,?,?,?>> KnownWorlds = new ConcurrentHashMap<>();

    public static final Map.Entry<Terrene, Director<?,?,?,?>> Parse(String schema) {
        for (Map.Entry<Terrene, Director<?,?,?,?>> knownWorld: KnownWorlds.entrySet()) {
            if (knownWorld.getKey().schema.equals(schema)) {
                return knownWorld;
            }
        }
        throw new MatrixException(MatrixException.Type.Terrene_Not_Among_Known_Worlds,Terrene.class, Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("Schema: " + schema + ", is not used among known worlds."));
    }
    public static final Map.Entry<Terrene, Director<?,?,?,?>> Parse(char terrene) {
        for(Map.Entry<Terrene, Director<?,?,?,?>> knownWorld: KnownWorlds.entrySet()) {
            if (knownWorld.getKey().terrene == terrene) {
                return knownWorld;
            }
        }
        throw new MatrixException(MatrixException.Type.Terrene_Not_Among_Known_Worlds,Terrene.class, Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("Terrene needed: " + terrene + ", could not be found among known worlds."));
    }
    public final char terrene;
    public final String schema;
    public final String description;


    protected Terrene(String terrene, String schema, String description) {
        this((char) terrene.getBytes(StandardCharsets.UTF_8)[0], schema, description);
    }

    protected Terrene(char terrene, String schema, String description) {
        this.terrene = terrene;
        this.schema = schema;
        this.description = description;
        KnownWorlds.put(this, )
    }

    public char getTerrene() {
        return terrene;
    }

    public String getSchema() {
        return schema;
    }

    @Override
    public int compareTo(Terrene that) {
        return this.getTerrene() - that.getTerrene();
    }


    public final static class EarthRoots {

        public final Domain com_a = new Domain("com.a");
        public final Domain com_b = new Domain("com.b");
        public final Domain com_c = new Domain("com.c");
        public final Domain com_d = new Domain("com.d");
        public final Domain com_e = new Domain("com.e");
        public final Domain com_f = new Domain("com.f");
        public final Domain com_g = new Domain("com.g");
        public final Domain com_h = new Domain("com.h");
        public final Domain com_i = new Domain("com.i");
        public final Domain com_j = new Domain("com.j");
        public final Domain com_k = new Domain("com.k");
        public final Domain com_l = new Domain("com.l");
        public final Domain com_m = new Domain("com.m");

        protected final List<ServerRecord> serverRecords;
        public EarthRoots() {
            try {
                ServerRecord[] EARTH_ROOTS = new ServerRecord[]{
                    new ServerRecord(com_a, InetAddress.getByName("198.41.0.4"), Terrene.Earth),
                    new ServerRecord(com_a, InetAddress.getByName("2001:503:ba3e::2:30"), Terrene.Earth),
                    new ServerRecord(com_b, InetAddress.getByName("199.9.14.201"), Terrene.Earth),
                    new ServerRecord(com_b, InetAddress.getByName("2001:500:200::b"), Terrene.Earth),
                    new ServerRecord(com_c, InetAddress.getByName("192.33.4.12"), Terrene.Earth),
                    new ServerRecord(com_c, InetAddress.getByName("2001:500:2::c"), Terrene.Earth),
                    new ServerRecord(com_d, InetAddress.getByName("199.7.91.13"), Terrene.Earth),
                    new ServerRecord(com_d, InetAddress.getByName("2001:500:2d::d"), Terrene.Earth),
                    new ServerRecord(com_e, InetAddress.getByName("192.203.230.10"), Terrene.Earth),
                    new ServerRecord(com_e, InetAddress.getByName("2001:500:a8::e"), Terrene.Earth),
                    new ServerRecord(com_f, InetAddress.getByName("192.5.5.241"), Terrene.Earth),
                    new ServerRecord(com_f, InetAddress.getByName("2001:500:2f::f"), Terrene.Earth),
                    new ServerRecord(com_g, InetAddress.getByName("192.112.36.4"), Terrene.Earth),
                    new ServerRecord(com_g, InetAddress.getByName("2001:500:12::d0d"), Terrene.Earth),
                    new ServerRecord(com_h, InetAddress.getByName("198.97.190.53"), Terrene.Earth),
                    new ServerRecord(com_h, InetAddress.getByName("2001:500:1::53"), Terrene.Earth),
                    new ServerRecord(com_i, InetAddress.getByName("192.36.148.17"), Terrene.Earth),
                    new ServerRecord(com_i, InetAddress.getByName("2001:7fe::53"), Terrene.Earth),
                    new ServerRecord(com_j, InetAddress.getByName("192.58.128.30"), Terrene.Earth),
                    new ServerRecord(com_j, InetAddress.getByName("2001:503:c27::2:30"), Terrene.Earth),
                    new ServerRecord(com_k, InetAddress.getByName("193.0.14.129"), Terrene.Earth),
                    new ServerRecord(com_k, InetAddress.getByName("2001:7fd::1"), Terrene.Earth),
                    new ServerRecord(com_l, InetAddress.getByName("199.7.83.42"), Terrene.Earth),
                    new ServerRecord(com_l, InetAddress.getByName("2001:500:9f::42"), Terrene.Earth),
                    new ServerRecord(com_m, InetAddress.getByName("202.12.27.33"), Terrene.Earth),
                    new ServerRecord(com_m, InetAddress.getByName("2001:dc3::35"), Terrene.Earth)
            };
            ImmutableList.Builder<ServerRecord> builder = ImmutableList.builder();
            builder.add(EARTH_ROOTS);
            serverRecords = ImmutableList.<ServerRecord>builder().build();
        }
        catch (UnknownHostException unknownHostException) {
            throw new MatrixException(MatrixException.Type.UnknownHost,this.getClass(), Indicia.Focus.Assembly, Indicia.Severity.Exceptional,unknownHostException);
        }
    }

}
