package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Spirit extends Primogenitor<Hospitality,Persona, Psyche, Identity.Ego<Context.Service>, Context.Service,Skeleton,Spirit> {

    public Spirit(Persona fact, ReferenceQueue<Persona> referenceQueue, Skeleton omnibus, Psyche aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
