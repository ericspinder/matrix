package dev.inward.matrix.datum.fact.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public final class Persona extends Notion<Persona, Identity.Ego<Context.Service>,Context.Service,Spirit> {

    public Persona(Identity.Ego<Context.Service> id) {
        super(id);
    }
}
