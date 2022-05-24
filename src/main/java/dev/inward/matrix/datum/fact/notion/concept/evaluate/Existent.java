package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Existent extends Mortal<Bakery,Evaluate,Batch, Context.Service,Calc,Existent> {

    public Existent(Evaluate concept, ReferenceQueue<Evaluate> referenceQueue, Calc bus, Batch operational, Existent mortal, BigInteger initialSize) {
        super(concept, referenceQueue, bus, operational, mortal, initialSize);
    }
}
