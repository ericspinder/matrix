package dev.inward.matrix.fact.notion.concept.evaluate;

import dev.inward.matrix.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;

public class Existent extends Mortal<Bakery,Evaluate,Batch,Calc,Existent> {

    public Existent(Evaluate fact, ReferenceQueue<Evaluate> referenceQueue, Calc omnibus, Batch aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
