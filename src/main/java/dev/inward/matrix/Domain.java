package dev.inward.matrix;

import java.util.Map;
import java.util.WeakHashMap;

public final class Domain implements Comparable<Domain> {

    private final static Map<String,Domain> All_Known_Domains = new WeakHashMap<>();

    public synchronized static Domain getInstance(String domain_string) {
        Domain domain = All_Known_Domains.get(domain_string);
        if (domain != null) return domain;
        All_Known_Domains.put(domain_string, new Domain(domain_string));
        return All_Known_Domains.get(domain_string);
    }
    private final String domain;
    private final Map<String,Library<?,?,?>> schemeLibrary = new WeakHashMap<>();

    public Domain(String domain) {
        this.domain = domain;
        All_Known_Domains.put(domain, this);
    }

    @Override
    public int compareTo(Domain that) {
        return this.domain.compareTo(that.domain);
    }

    public String domain() {
        return domain;
    }

    @SuppressWarnings("unchecked")
    public synchronized <S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>> L getLibrary(S scheme) {
        L library = (L) schemeLibrary.get(scheme.scheme);
        if (library != null) return library;
        schemeLibrary.put(scheme.scheme, new Library<>(scheme,this));
        return (L) schemeLibrary.get(scheme.scheme);
    }

    public String getDomain() {
        return domain;
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
