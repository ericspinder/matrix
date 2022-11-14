package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.Omnibus;
import dev.inward.matrix.fact.notion.concept.Context;

public class Passage extends Omnibus<Agency,Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent> {
    public Passage(Journey operational) {
        super(operational);
    }
}
