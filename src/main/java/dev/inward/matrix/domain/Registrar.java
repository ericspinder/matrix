package dev.inward.matrix.domain;

import java.util.Map;

public class Registrar {

    protected final Registrar issuer;
    protected final Map<Domain, Orders> domainOrdersMap;

    public Registrar(Registrar issuer, Map<Domain,Orders> domainOrdersMap) {
        this.issuer = issuer;
        this.domainOrdersMap = domainOrdersMap;
    }

    public Registrar getIssuer() {
        return issuer;
    }

    public Map<Domain, Orders> getDomainOrdersMap() {
        return domainOrdersMap;
    }
}
