package dev.inward.matrix.fact.notion.concept.corpus;

import dev.inward.matrix.LocalSystemNetworking;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Concept;

public class Corpus extends Concept<Corpus,Prophet> {

    protected LocalSystemNetworking networking = LocalSystemNetworking.getInstance();

    public Corpus(Identity.Ego id) {
        super(id);
    }



}
