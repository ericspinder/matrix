/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix.container.domain;

import dev.inward.matrix.HostExperience;
import dev.inward.matrix.Matrix;
import dev.inward.matrix.container.ContainerItem;
import dev.inward.matrix.file.addressed.dns.nameServerRecord.NameServerRecord;
import dev.inward.matrix.file.addressed.dns.serverRecord.ServerRecord;
import dev.inward.matrix.predictable.Director;
import dev.inward.matrix.predictable.Predictable;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Domain implements ContainerItem<DomainKey,Domain,DomainView,DomainModel,DomainReference, DomainSteward> {

    private static final Map<String,Domain> ALL_BUILT_DOMAINS = new ConcurrentHashMap<>();

    private final Predictable predictable = new Predictable(this);
    protected static Domain get(DomainKey domainKey) {
        String domainKeyString = domainKey.toString();
        if (!ALL_BUILT_DOMAINS.containsKey(domainKeyString)) {
            newDomain(domainKey);
        }
        return ALL_BUILT_DOMAINS.get(domainKeyString);
    }
    protected synchronized static void newDomain(DomainKey domainKey) {
        String domainKeyString = domainKey.toString();
        if (!ALL_BUILT_DOMAINS.containsKey(domainKeyString)) {
            ALL_BUILT_DOMAINS.put(domainKeyString,new Domain(domainKey));
        }
    }
    private final List<HostExperience> nameServerRecordHostExperienceMap = new ArrayList<>();
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
        //nameServerRecordHostExperienceMap.add(new HostExperience.Server(serverRecord, 10, nameServerRecord));
    }
    public void removeServer(HostExperience hostExperience) {
        nameServerRecordHostExperienceMap.remove(hostExperience);
    }

    private final Director director;
    protected final DomainKey domainKey;

    protected Domain(DomainKey domainKey) {
        this.domainKey = domainKey;
        this.director = Matrix.getInstance().getDirector(this);
    }

    @Override
    public DomainKey getKey() {
        return null;
    }

    protected void initLedgerRecords() {
        try {
            InitialDirContext dirContext = new InitialDirContext();
            Attribute attr = dirContext.getAttributes("dns:" + domainKey.getDomainName(), new String[]{"TXT"}).get("TXT");
            Attribute attr2 = dirContext.getAttributes("dns:" + domainKey.getDomainName(), new String[]{"CNAME"}).get("CNAME");
        }
        catch (NamingException e) {
            throw new RuntimeException("Problem getting Ledger records for " + domainKey.getDomainName(),e);
        }
    }

    public Director getDirector() {
        return director;
    }

}
