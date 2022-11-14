package dev.inward.matrix.phenomenon.producer.communications;

import dev.inward.matrix.fact.notion.concept.Mortal;

public class ThreadedConcept extends ThreadLocal<Mortal<?,?>> {

    public static ThreadedConcept Instance = new ThreadedConcept();

    private ThreadedConcept() {

    }

}
