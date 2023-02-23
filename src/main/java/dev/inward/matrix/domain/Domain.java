package dev.inward.matrix.domain;

import dev.inward.matrix.fact.authoritative.notion.authority.Authority;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Domain implements Comparable<Domain> {

    protected final Domain parent;
    protected final String name;
    protected final Map<InternetClass,Authority> authorities = new ConcurrentHashMap<>();

    public Domain(Domain parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public Authority getAuthority(InternetClass internetClass) {
        return authorities.getOrDefault(internetClass);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Domain that) {
        return this.name.
        return isZero;
    }
    public URL getURL() {
        StringBuilder stringBuilder = new StringBuilder();
        while (authority != null && authority.getIdentity().getContext().getDomain() != null) {
            stringBuilder.append(authority.getIdentity().getContext().getDomain().name).append('.');
        }
    }

}
