package dev.inward.matrix.fact.authoritative.notion.connector;

import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.Context;

public class Passage extends Omnibus<Agency,Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent> {
    public Passage(Journey operational) {
        super(operational);
    }
}
