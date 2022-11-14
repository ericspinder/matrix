package dev.inward.matrix.fact.notion.person;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Omnibus;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.personality.Persona;


public final class Skeleton extends Omnibus<Hospitality, Persona,Psyche, Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Skeleton(Psyche psyche) {
        super(psyche);
    }
}
