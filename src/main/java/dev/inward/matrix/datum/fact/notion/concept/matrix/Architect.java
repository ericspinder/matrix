package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Immortal;

import java.lang.ref.ReferenceQueue;

public class Architect extends Immortal<Construct,Matrix,Interface, Context.Service,Loader,Architect> {

    public Architect(Matrix concept, ReferenceQueue<Matrix> referenceQueue, Loader bus, Interface operational) {
        super(concept, referenceQueue, bus, operational);
    }
}
