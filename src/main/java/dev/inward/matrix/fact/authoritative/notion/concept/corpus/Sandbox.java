package dev.inward.matrix.fact.authoritative.notion.concept.corpus;

import dev.inward.matrix.fact.authoritative.notion.concept.Volume;
import dev.inward.matrix.fact.authoritative.notion.house.Assembly;
import dev.inward.matrix.fact.authoritative.notion.house.Steward;

public class Sandbox<A extends > extends Volume<Assembly, Corpus,Mechanical,Sandbox, Steward> {

    public Sandbox(Mechanical operational) {
        super(operational);
    }
}
