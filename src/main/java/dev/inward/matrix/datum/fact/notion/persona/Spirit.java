package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Spirit extends Ambassador<Hospitality,Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit, Corpus, Prophet> {

    public Spirit(Persona fact, ReferenceQueue<Persona> referenceQueue, Skeleton omnibus, Psyche aspect, Prophet mortal, BigInteger initialSize) {
        super(fact, referenceQueue, omnibus, aspect, mortal, initialSize);
    }
}
