package dev.inward.matrix.fact.authoritative.yard;

import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.authority.dns.resourceRecord.ResourceRecordType;
import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Indicia;

import javax.security.auth.Subject;
import java.net.InetAddress;
import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tree implements Principal,Comparable<Tree> {

    protected final InetAddress inetAddress;
    protected Map<ResourceRecordType, ResourceRecord[]> resourceRecordTypeMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<Indicia, Identity.Gate> matterCollectors;

    public Tree() {
        this.matterCollectors = matterCollectors;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }

    public Identity.Gate getMatterCollector(Indicia indicia) {
        return this.matterCollectors.getOrDefault(indicia,defaultCollector);
    }

    @Override
    public int compareTo(Tree o) {
        return 0;
    }

    public final Tree satisfies(Matrix authority) {
        authority. \
    }
}
