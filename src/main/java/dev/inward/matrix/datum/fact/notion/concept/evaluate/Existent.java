package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Immortal;

import java.lang.ref.ReferenceQueue;

public class Existent extends Immortal<Bakery,Evaluate,Batch, Context.Service,Calc,Existent> {

    public Existent(Evaluate concept, ReferenceQueue<Evaluate> referenceQueue, Calc bus, Batch operational) {
        super(concept, referenceQueue, bus, operational);
    }
}
