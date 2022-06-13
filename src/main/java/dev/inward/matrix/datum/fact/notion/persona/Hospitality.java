package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;
import dev.inward.matrix.meta.Standard;



import java.util.Map;

public class Hospitality extends Industry<Hospitality,Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit, Corpus, Prophet> {


    public Hospitality(Spirit parent, Map<Standard<?, Persona, Identity.SuperEgo, Context.Service>, Resources<Hospitality, ?, ?, ?, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit>> resourceMap) {
        super(parent, resourceMap);
    }


}
