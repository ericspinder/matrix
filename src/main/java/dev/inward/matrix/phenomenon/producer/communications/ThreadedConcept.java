package dev.inward.matrix.phenomenon.producer.communications;

import crud.Protocol;

public class ThreadedConcept extends ThreadLocal<Protocol> {

    public static ThreadedConcept Instance = new ThreadedConcept();

    private ThreadedConcept() {

    }

}
