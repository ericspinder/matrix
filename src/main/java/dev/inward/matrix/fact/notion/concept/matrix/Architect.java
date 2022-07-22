package dev.inward.matrix.fact.notion.concept.matrix;

import dev.inward.matrix.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Architect extends Mortal<Construct,Matrix,Interface,Loader,Architect> {

    public Architect(Matrix fact, ReferenceQueue<Matrix> referenceQueue, Loader omnibus, Interface aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
