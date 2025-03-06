/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix;

import dev.inward.matrix.file.addressed.dns.nameServerRecord.NameServerRecord;
import dev.inward.matrix.file.addressed.dns.serverRecord.ServerRecord;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Domain implements MatrixItem<DomainKey,Domain> {

    private final static Map<String,Domain> All_Known_Domains = new HashMap<>();

    public synchronized static Domain getInstance(String domain_string) {
        Domain domain = All_Known_Domains.get(domain_string);
        if (domain != null) return domain;
        All_Known_Domains.put(domain_string, new Domain(domain_string));
        return All_Known_Domains.get(domain_string);
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
        nameServerRecordHostExperienceMap.add(new HostExperience.NameServer(serverRecord, 10, nameServerRecord));
    }
    public void removeServer(HostExperience hostExperience) {
        nameServerRecordHostExperienceMap.remove(hostExperience);
    }

    private final Director director;

    private final DomainKey domainKey;

    private Domain(String domain) {
        this.domainKey = new DomainKey(domain);
        All_Known_Domains.put(domain, this);
        this.director = Ziggurat.getInstance().getDirector(this);
    }
    protected void initLedgerRecords() {
        try {
            InitialDirContext dirContext = new InitialDirContext();
            Attribute attr = dirContext.getAttributes("dns:" + getDomain(), new String[]{"TXT"}).get("TXT");
            Attribute attr2 = dirContext.getAttributes("dns:" + getDomain(), new String[]{"CNAME"}).get("CNAME");
        }
        catch (NamingException e) {
            throw new RuntimeException("Problem getting Ledger records for " + getDomain(),e);
        }
    }

    @Override
    public DomainKey getKey() {
        return this.domainKey;
    }

    @Override
    public int compareTo(Domain that) {
        return this.domainKey.compareTo(that.domainKey);
    }

    public String getDomain() {
        return domainKey.uri.getHost();
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Domain{ domain = " + domainKey.uri.getHost() + '}';
    }
}
