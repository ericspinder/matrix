package dev.inward.matrix.fact.authoritative.yard;

import dev.inward.matrix.authority.ResourceRecord;
import dev.inward.matrix.authority.ResourceRecordType;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;

import javax.security.auth.Subject;
import java.net.InetAddress;
import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tree implements Principal,Comparable<Tree> {

    protected final InetAddress inetAddress;
    protected Map<ResourceRecordType, ResourceRecord[]> resourceRecordTypeMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<Indicia, Identity.SuperEgo> matterCollectors;

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
    public boolean implies(Tree tree) {

    }

    public Identity.SuperEgo getMatterCollector(Indicia indicia) {
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
