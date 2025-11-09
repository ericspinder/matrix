/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.terrene;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.net.URLStreamHandler;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Terrene extends URLStreamHandler implements Control<Terrene,TerreneView,TerreneModel> {
//    public static final Terrene Earth = new Terrene("IN","earth");
//    public static final Terrene Luna = new Terrene("LN","luna.earth");
//    public static final Terrene Mars = new Terrene("MR", "mars");
//    public static final Terrene Helios = new Terrene("HS","helios");
//    public static final Terrene Chaosnet = new Terrene("CS","chaosnet");
//    public static final Terrene Aforementioned = new Terrene('\u0000',"aforementioned");

    protected static final Map<String,Terrene> KnownWorlds = new ConcurrentHashMap<>();

    public static Terrene Parse(String label) {
        if (label == null || label.isEmpty()) {
            label = "earth";
        }
        Terrene terrene = KnownWorlds.get(label);
        if (terrene == null) {
            throw new IllegalArgumentException("Unknown Terrene: " + label);
        }
        return terrene;
    }

    public final char dnsClassCode;
    public final String[] labels;
    protected final Map<String, Reference<Domain>> domains = new ConcurrentHashMap<>();

    protected Terrene(String classCodeString, String label) {
        this((char) classCodeString.getBytes(StandardCharsets.UTF_8)[0], label);
    }

    protected Terrene(char dnsClassCode, String... labels) {
        this.dnsClassCode = dnsClassCode;
        this.labels = labels;
        for (String label: labels) {
            KnownWorlds.put(label,this);
        }
    }

    public char getDnsClassCode() {
        return this.dnsClassCode;
    }

    public String[] getLabels() {
        return this.labels;
    }

    @Override
    public int compareTo(Terrene that) {
        return this.dnsClassCode - that.dnsClassCode;
    }

    protected synchronized Domain newDomain(String domainName) {
        if (domains.containsKey(domainName) && domains.get(domainName).get() != null) {
            return domains.get(domainName).get();
        }
        Domain domain = new Domain(this, domainName);
        domains.put(domainName,new SoftReference<>(domain));
        return domain;
    }
    public Domain getDomain(String domainName) {
        if (domains.containsKey(domainName) && domains.get(domainName).get() != null) {
            return domains.get(domainName).get();
        }
        return newDomain(domainName );
    }
}
