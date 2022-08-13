package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;

public class Architect extends Mortal<Construct,Matrix,Interface,Loader,Architect> {

    public Architect(Matrix fact, ReferenceQueue<Matrix> referenceQueue, Loader omnibus, Interface aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
