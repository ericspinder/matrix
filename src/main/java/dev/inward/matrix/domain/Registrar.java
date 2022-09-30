package dev.inward.matrix.domain;

import dev.inward.matrix.matter.order.Order;

import java.util.Map;

public class Registrar {

    protected final Registrar issuer;
    protected final Map<Domain, Order> domainOrdersMap;

    public Registrar(Registrar issuer, Map<Domain, Order> domainOrdersMap) {
        this.issuer = issuer;
        this.domainOrdersMap = domainOrdersMap;
    }

    public Registrar getIssuer() {
        return issuer;
    }

    public Map<Domain, Order> getDomainOrdersMap() {
        return domainOrdersMap;
    }
}
