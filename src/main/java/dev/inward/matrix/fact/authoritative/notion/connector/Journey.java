package dev.inward.matrix.fact.authoritative.notion.connector;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Journey extends Aspect<Agency,Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent> {

    public Journey(Specification specification, Supplier<Agency, Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
