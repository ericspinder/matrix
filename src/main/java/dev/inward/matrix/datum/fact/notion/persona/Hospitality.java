package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Hospitality extends Industry<Hospitality, Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Hospitality(Resources<Hospitality, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, Identity.SuperEgo, Context.Service> resources) {
        super(resources);
    }
}
