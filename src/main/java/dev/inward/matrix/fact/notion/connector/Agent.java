package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Ambassador;
import dev.inward.matrix.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Agent extends Ambassador<Agency,Connector, Journey, Identity.Ego,Context.JVM, Passage, Agent> {

    public Agent(Connector fact, ReferenceQueue<Connector> referenceQueue, Passage omnibus, Journey aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
