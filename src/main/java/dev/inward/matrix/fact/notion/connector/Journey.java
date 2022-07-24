package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Journey extends Aspect<Agency,Connector, Journey, Identity.Ego,Context.JVM, Passage, Agent> {

    public Journey(Specification specification, Supplier<Agency, Connector, Journey, Identity.Ego, Context.JVM, Passage, Agent, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
