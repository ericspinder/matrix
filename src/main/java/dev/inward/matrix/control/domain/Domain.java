/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix.control.domain;

import dev.inward.matrix.HostExperience;
import dev.inward.matrix.ProtocolParser;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.terrene.Terrene;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.dns.DnsScheme;
import dev.inward.matrix.concept.file.addressed.dns.nameServerRecord.NameServerRecord;
import dev.inward.matrix.concept.file.addressed.dns.serverRecord.ServerRecord;
import dev.inward.matrix.predictable.Director;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Domain implements Control<Domain,DomainView,DomainModel> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createTime = Instant.now();

    protected final Terrene terrene;
    protected final String domainName;
    private Director director;
    protected final Map<? extends Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>,Scheme.Experience> schemeDirectorMap = new WeakHashMap<>();
    public Domain(Terrene terrene, String domainName) {
        this.terrene = terrene;
        this.domainName = domainName;
    }
    public Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getScheme(ProtocolParser<?> protocolParser) {
        for (Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> scheme: this.schemeDirectorMap.keySet()) {
            if (scheme.getProtocolParser().getProtocol().this.dnsScheme = new DnsScheme(terrene,)
        }
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Instant getCreateInstant() {
        return createTime;
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public String getDomainName() {
        return domainName;
    }

    private final Map<ServerRecord<?,?,?,?,?,?>,HostExperience> nameServerRecordHostExperienceMap = new ArrayList<>();
    private final AtomicInteger serverCount = new AtomicInteger();
    public HostExperience getNextServer() {
        try {
            return nameServerRecordHostExperienceMap.get(serverCount.incrementAndGet());
        }
        finally {
            if (serverCount.get() > Integer.MAX_VALUE - 1000) {
                serverCount.set(0);
            }
        }
    }
    public void addNameServer(ServerRecord serverRecord,NameServerRecord nameServerRecord) {
        nameServerRecordHostExperienceMap.add(new HostExperience.Server(serverRecord, 10, nameServerRecord));
    }
    public void removeServer(HostExperience hostExperience) {
        nameServerRecordHostExperienceMap.remove(hostExperience);
    }

    protected void initLedgerRecords() {
        try {
            InitialDirContext dirContext = new InitialDirContext();
            Attribute attr = dirContext.getAttributes("dns:" + domainName, new String[]{"TXT"}).get("TXT");
            Attribute attr2 = dirContext.getAttributes("dns:" + domainName, new String[]{"CNAME"}).get("CNAME");
        }
        catch (NamingException e) {
            throw new RuntimeException("Problem getting Ledger records for " + domainName,e);
        }
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public int compareTo(Domain that) {
        int isZero = this.domainName.compareTo(that.domainName);
        if (isZero == 0) {
            return this.terrene.compareTo(that.terrene);
        }
        return isZero;
    }

}
