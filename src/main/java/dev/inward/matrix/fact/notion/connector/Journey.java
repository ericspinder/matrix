package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Journey extends Aspect<Agency,Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent> {

    public Journey(Specification specification, Supplier<Agency, Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
