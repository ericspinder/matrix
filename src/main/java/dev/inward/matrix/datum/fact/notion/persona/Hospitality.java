package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Hospitality extends Industry<Hospitality, Persona,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Hospitality(Storage<Hospitality, Persona, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, Identity.SuperEgo, Context.Service> storage) {
        super(storage);
    }
}
