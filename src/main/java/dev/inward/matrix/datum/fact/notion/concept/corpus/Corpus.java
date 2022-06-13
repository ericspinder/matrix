package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.LocalSystemNetworking;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Concept;

import java.net.InetSocketAddress;

public class Corpus extends Concept<Corpus,Prophet> {

    protected LocalSystemNetworking networking = LocalSystemNetworking.getInstance();

    public Corpus(Identity.Ego id) {
        super(id);
    }



}
