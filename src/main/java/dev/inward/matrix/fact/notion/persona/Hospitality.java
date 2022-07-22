package dev.inward.matrix.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.corpus.*;
import dev.inward.matrix.meta.Standard;



import java.util.Map;

public class Hospitality extends Industry<Hospitality,Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit,Assembly,Corpus,Mechanical,Sandbox,Prophet> {


    public Hospitality(Prophet mortal, Resources resources, Map<Standard<?, Persona, Identity.SuperEgo, Context.Service>, Resource<Hospitality, ?, ?, ?, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
