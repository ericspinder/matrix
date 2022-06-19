package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.meta.Standard;



import java.util.Map;

public class Hospitality extends Industry<Hospitality,Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit,Assembly,Corpus,Mechanical,Sandbox,Prophet> {

    public Hospitality(Prophet prophet, Map<Standard<?, Persona, Identity.SuperEgo, Context.Service>, Resource<Hospitality, ?, ?, ?, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit>> resourceMap) {
        super(prophet, resourceMap);
    }

}
