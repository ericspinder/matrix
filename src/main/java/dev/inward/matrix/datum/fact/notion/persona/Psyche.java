package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

public class Psyche extends Aspect<Hospitality,Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit, Corpus,Prophet> {

    public Psyche(Options options, Supplier<Hospitality, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, Persona, Spirit> supplier) {
        super(options, supplier);
    }
}
