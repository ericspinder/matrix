package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.meta.Standard;



import java.util.Map;

public class Hospitality extends Industry<Hospitality,Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Hospitality(Resources<Hospitality, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, Identity.SuperEgo, Context.Service> resources) {
        super(resources);
    }
}
