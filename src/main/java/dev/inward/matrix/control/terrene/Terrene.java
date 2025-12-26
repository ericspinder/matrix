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
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Terrene extends URLStreamHandler implements Control<Terrene,TerreneView,TerreneModel> {

    private static Map<String, Terrene> KnownWorlds() {
        Map<String, Terrene> knownWorlds = new ConcurrentHashMap<>();
        knownWorlds.put("earth",new Earth());
        knownWorlds.put("luna", new Luna());
        knownWorlds.put("mars", new Mars());
        knownWorlds.put("helios", new Helios());
        knownWorlds.put("chaosnet", new Chaosnet());
        knownWorlds.put("hesiod", new Hesiod());
        return knownWorlds;
    }
    public static final Map<String, Terrene> KnownWorlds = KnownWorlds();


    protected Domain localhostDomain = new Domain(this, "localhost");

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
    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createTime = Instant.now();
    public final char dnsClassCode;
    public final String[] labels;
    protected final Map<String, Reference<Domain>> domains = new ConcurrentHashMap<>();

    protected Terrene(String classCodeString, String label) {
        this((char) classCodeString.getBytes(StandardCharsets.UTF_8)[0], label);
        this.domains.put(localhostDomain.getDomainName(),new SoftReference<>(localhostDomain));
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

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Instant getCreateInstant() {
        return createTime;
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
