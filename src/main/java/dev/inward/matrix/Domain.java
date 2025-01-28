package dev.inward.matrix;

import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Road;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class Domain implements Comparable<Domain> {

    private final static Map<String,Domain> All_Known_Domains = new HashMap<>();


    public synchronized static Domain getInstance(String domain_string) {
        Domain domain = All_Known_Domains.get(domain_string);
        if (domain != null) return domain;
        All_Known_Domains.put(domain_string, new Domain(domain_string));
        return All_Known_Domains.get(domain_string);
    }
    private final String domain;

    private Director.Network networkDirector;
    private Domain(String domain) {
        this.domain = domain;
        All_Known_Domains.put(domain, this);
        this.networkDirector = Ziggurat.getInstance().getNetworkDirector();
    }

    @Override
    public int compareTo(Domain that) {
        return this.domain.compareTo(that.domain);
    }

    public String domain() {
        return domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setNetworkDirector(Director.Network networkDirector) {
        this.networkDirector = networkDirector;
    }

    public Director.Network getNetworkDirector() {
        return networkDirector;
    }

    @Override
    public String toString() {
        return "Domain{ domain = " + domain + '}';
    }
}
