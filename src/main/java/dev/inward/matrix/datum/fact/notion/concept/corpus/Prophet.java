package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import javax.security.auth.Subject;
import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Prophet extends Mortal<Assembly,Corpus,Mechanical,Sandbox,Prophet> {

    public Prophet(Corpus fact, ReferenceQueue<Corpus> referenceQueue, Sandbox omnibus, Mechanical aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
