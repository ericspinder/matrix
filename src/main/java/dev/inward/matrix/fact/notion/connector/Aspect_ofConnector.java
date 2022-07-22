package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.boot.Boot;
import dev.inward.matrix.fact.notion.concept.boot.Root;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Aspect_ofConnector extends Aspect<Industry_forConnector,Connector,Aspect_ofConnector, Identity.Ego,Context.JVM, Omnibus_forConnector, Ambassador_holdingConnector> {

    public Aspect_ofConnector(Specification specification, Supplier<Industry_forConnector, Connector, Aspect_ofConnector, Identity.Ego, Context.JVM, Omnibus_forConnector, Ambassador_holdingConnector, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
