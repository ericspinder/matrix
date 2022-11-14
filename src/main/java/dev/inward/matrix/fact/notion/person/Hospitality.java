package dev.inward.matrix.fact.notion.person;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.Context;

public class Hospitality extends Industry<Hospitality, Person,Psyche,Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Hospitality(Storage<Hospitality, Person, Psyche, Identity.SuperEgo, Context.Service, Skeleton, Spirit, Identity.SuperEgo, Context.Service> storage) {
        super(storage);
    }
}
