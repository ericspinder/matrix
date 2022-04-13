package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.Agent.Agent;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public final class Boot extends Concept<Boot, Context.JVM, Root> {

    protected final Agent agent;

    public Boot(Identity.SuperEgo<Context.JVM> id, Agent agent) {
        super(id);
        this.agent = agent;
    }


    public Agent getAgent() {
        return this.agent;
    }
}
