package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;

public final class Skeleton extends Omnibus<Hospitality,Persona,Psyche, Identity.SuperEgo,Context.Service,Skeleton,Spirit, Corpus, Prophet> {

    public Skeleton(Psyche psyche) {
        super(psyche);
    }
}
