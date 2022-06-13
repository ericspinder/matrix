package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import javax.security.auth.Subject;
import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Prophet extends Mortal<Assembly, Corpus,Mechanical,Sandbox,Prophet> {

    public Prophet(Corpus concept, ReferenceQueue<Corpus> referenceQueue, Sandbox bus, Mechanical operational, Prophet mortal, BigInteger initialSize, Subject authSubject) {
        super(concept, referenceQueue, bus, operational, mortal, initialSize, authSubject);
    }
}
