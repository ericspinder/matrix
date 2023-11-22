package dev.inward.matrix.fact.authoritative.notion.concept.evaluate;

import dev.inward.matrix.fact.authoritative.notion.concept.Construct;

import java.lang.ref.ReferenceQueue;

public class Existent extends Construct<Bakery,Evaluate,Batch,Calc,Existent> {

    public Existent(Evaluate fact, ReferenceQueue<Evaluate> referenceQueue, Calc omnibus, Batch aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
