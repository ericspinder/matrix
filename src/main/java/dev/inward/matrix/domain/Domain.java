package dev.inward.matrix.domain;

import dev.inward.matrix.datum.fact.notion.authority.Authority;

public class Domain implements Comparable<Domain> {

    protected final Authority authority;
    protected final String name;

    public Domain(String name, Authority authority) {
        this.authority = authority;
        this.name = name;
    }

    public Authority getAuthority() {
        return authority;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Domain that) {
        int isZero = this.authority.compareTo(that.authority);
        if (isZero == 0) {
            return this.name.compareTo(that.name);
        }
        return isZero;
    }
}
