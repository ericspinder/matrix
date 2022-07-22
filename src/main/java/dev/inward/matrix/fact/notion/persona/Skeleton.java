package dev.inward.matrix.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Omnibus;
import dev.inward.matrix.fact.notion.concept.Context;


public final class Skeleton extends Omnibus<Hospitality,Persona,Psyche, Identity.SuperEgo,Context.Service,Skeleton,Spirit> {

    public Skeleton(Psyche psyche) {
        super(psyche);
    }
}
