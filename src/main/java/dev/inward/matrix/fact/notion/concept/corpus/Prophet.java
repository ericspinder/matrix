package dev.inward.matrix.fact.notion.concept.corpus;

import dev.inward.matrix.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;

public class Prophet extends Mortal<Assembly,Corpus,Mechanical,Sandbox,Prophet> {

    public Prophet(Corpus fact, ReferenceQueue<Corpus> referenceQueue, Sandbox omnibus, Mechanical aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
