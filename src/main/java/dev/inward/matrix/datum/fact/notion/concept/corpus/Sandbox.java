package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.fact.notion.concept.Volume;
import dev.inward.matrix.datum.fact.notion.house.Assembly;
import dev.inward.matrix.datum.fact.notion.house.Prophet;

public class Sandbox<A extends > extends Volume<Assembly, Corpus,Mechanical,Sandbox, Prophet> {

    public Sandbox(Mechanical operational) {
        super(operational);
    }
}
