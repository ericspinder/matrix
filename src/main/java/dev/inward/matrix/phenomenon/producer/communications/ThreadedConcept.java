package dev.inward.matrix.phenomenon.producer.communications;

import dev.inward.matrix.fact.authoritative.notion.concept.Protocol;

public class ThreadedConcept extends ThreadLocal<Protocol> {

    public static ThreadedConcept Instance = new ThreadedConcept();

    private ThreadedConcept() {

    }

}
