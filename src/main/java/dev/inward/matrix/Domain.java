package dev.inward.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class Domain implements Comparable<Domain> {

    private final static Map<String,Domain> All_Known_Domains = new HashMap<>();

    public synchronized static Domain getInstance(Terrene terrene, String domain_string) {
        Domain domain = All_Known_Domains.get(terrene.toString() + '.' + domain_string);
        if (domain != null) return domain;
        All_Known_Domains.put(terrene.toString() + '.' + domain_string, new Domain(terrene, domain_string));
        return All_Known_Domains.get(domain_string);
    }
    private final Terrene terrene;
    private final String domain;

    private Domain(Terrene terrene, String domain) {
        this.terrene = terrene;
        this.domain = domain;
        All_Known_Domains.put(terrene.toString() + '_' + domain, this);
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

    public Terrene getTerrene() {
        return terrene;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Domain{");
        sb.append("domain='").append(domain).append('\'');
        sb.append(", schemeLibrary=");
        for (Map.Entry<String,Library<?,?,?>> schemaLibrary: schemeLibrary.entrySet()) {
            sb.append(schemaLibrary.getKey()).append(" bound for ").append(schemaLibrary.getValue().)
        }
        sb.append('}');
        return sb.toString();
    }
}
