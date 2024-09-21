package dev.inward.matrix.authority;

import dev.inward.matrix.*;
import dev.inward.matrix.memory.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.Notion;
import dev.inward.matrix.concept.matter.order.Autopsy;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.util.Map;

public class Office extends Library<DNS, Office> {

    protected final Office issuer;
    protected final Map<Domain, Autopsy> domainOrdersMap;

    public Office(Office issuer, Map<Domain, Autopsy> domainOrdersMap) {
        this.issuer = issuer;
        this.domainOrdersMap = domainOrdersMap;
    }

    public Office getIssuer() {
        return issuer;
    }

    public Map<Domain, Autopsy> getDomainOrdersMap() {
        return domainOrdersMap;
    }

    @Override
    protected <ID extends Comparable<ID>, Q extends Manufacture<DNS, Office, PATH, ID, Q>, D extends Gathering<DNS, Office, PATH, D, O, F>, O extends Notion<DNS, Office, PATH, O>, N extends Fact.Named<DNS, Office, PATH, N, F>, F extends Fact<DNS, Office, PATH, N, F>> Catalog<DNS, Office, PATH, D, O, N> initCatalog(Library<DNS, Office> library, Memory<DNS, Office, PATH> memory, Dogma.Ethereal<DNS, Office, PATH, ID, Q> ethereal) throws CheckedException {
        return null;
    }

    @Override
    public int compareTo(Office o) {
        return 0;
    }

    @Override
    public UserPrincipal lookupPrincipalByName(String name) throws IOException {
        return null;
    }

    @Override
    public GroupPrincipal lookupPrincipalByGroupName(String group) throws IOException {
        return null;
    }
}
