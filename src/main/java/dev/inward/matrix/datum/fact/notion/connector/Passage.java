package dev.inward.matrix.datum.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Passage extends Omnibus<Agency,Connector, Journey, Identity.Ego, Context.JVM, Passage, Agent> {
    public Passage(Journey operational) {
        super(operational);
    }
}
