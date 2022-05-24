package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Architect extends Mortal<Construct,Matrix,Interface, Context.Service,Loader,Architect> {


    public Architect(Matrix concept, ReferenceQueue<Matrix> referenceQueue, Loader bus, Interface operational, Architect mortal, BigInteger initialSize) {
        super(concept, referenceQueue, bus, operational, mortal, initialSize);
    }
}
