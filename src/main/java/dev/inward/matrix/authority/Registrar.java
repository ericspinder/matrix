package dev.inward.matrix.authority;

import dev.inward.matrix.fact.matter.order.Autopsy;

import java.util.Map;

public class Registrar {

    protected final Registrar issuer;
    protected final Map<Domain, Autopsy> domainOrdersMap;

    public Registrar(Registrar issuer, Map<Domain, Autopsy> domainOrdersMap) {
        this.issuer = issuer;
        this.domainOrdersMap = domainOrdersMap;
    }

    public Registrar getIssuer() {
        return issuer;
    }

    public Map<Domain, Autopsy> getDomainOrdersMap() {
        return domainOrdersMap;
    }
}
