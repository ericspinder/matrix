/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import com.google.common.collect.ImmutableList;
import dev.inward.matrix.file.addressed.dns.serverRecord.ServerRecord;
import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;
import dev.inward.matrix.file.addressed.log.Matter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Terrene implements Comparable<Terrene> {
    public static final Terrene Earth = new Terrene("IN","earth");
    public static final Terrene Luna = new Terrene("LN","luna.earth");
    public static final Terrene Mars = new Terrene("MR", "mars");
    public static final Terrene Helios = new Terrene("HS","helios");
    public static final Terrene Chaosnet = new Terrene("CS","chaosnet");
    public static final Terrene Aforementioned = new Terrene('\u0000',"aforementioned");

    protected static final Map<String,Terrene> KnownWorlds = new ConcurrentHashMap<>();

    public static Terrene Parse(String alias) {
        Terrene terrene = KnownWorlds.get(alias);
        if (terrene == null) throw new RuntimeException("Terrene not found: " + alias);
        return terrene;
    }

    public final char terrene;
    public final String[] aliases;

    protected Terrene(String terrene, String... alias) {
        this((char) terrene.getBytes(StandardCharsets.UTF_8)[0], alias);
    }

    protected Terrene(char terrene, String... aliases) {
        this.terrene = terrene;
        this.aliases = aliases;
        for (String alias: aliases) {
            KnownWorlds.put(alias,this);
        }
    }

    public char getTerrene() {
        return terrene;
    }

    public String[] getAliases() {
        return aliases;
    }

    @Override
    public int compareTo(Terrene that) {
        return this.getTerrene() - that.getTerrene();
    }


    public final static class EarthRoots {

        public final Domain com_a = Domain.getInstance(Earth,"com.a");
        public final Domain com_b = Domain.getInstance(Earth,"com.b");
        public final Domain com_c = Domain.getInstance(Earth,"com.c");
        public final Domain com_d = Domain.getInstance(Earth, "com.d");
        public final Domain com_e = Domain.getInstance(Earth, "com.e");
        public final Domain com_f = Domain.getInstance(Earth, "com.f");
        public final Domain com_g = Domain.getInstance(Earth, "com.g");
        public final Domain com_h = Domain.getInstance(Earth, "com.h");
        public final Domain com_i = Domain.getInstance(Earth, "com.i");
        public final Domain com_j = Domain.getInstance(Earth, "com.j");
        public final Domain com_k = Domain.getInstance(Earth, "com.k");
        public final Domain com_l = Domain.getInstance(Earth, "com.l");
        public final Domain com_m = Domain.getInstance(Earth, "com.m");

        private final List<ServerRecord> serverRecords;

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
            } catch (UnknownHostException unknownHostException) {
                throw new MatrixException(MatrixException.Type.UnknownHost, "EarthRoots", IndiciaKey.Focus.Assembly, Matter.Severity.Exceptional, unknownHostException);
            }
        }
    }
}
