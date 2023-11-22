package dev.inward.matrix.fact.authoritative.notion.concept.corpus;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.concept.Protocol;
import dev.inward.matrix.fact.authoritative.notion.house.Steward;

public class Corpus extends Protocol<Corpus, Steward> {

    public Corpus(Identity.Ego id) {
        super(id);
    }

}
