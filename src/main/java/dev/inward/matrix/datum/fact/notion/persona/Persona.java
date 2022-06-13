package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import javax.security.auth.Subject;
import java.security.Principal;

public final class Persona extends Notion<Persona, Identity.SuperEgo,Context.Service,Spirit> implements Principal {

    protected final String name;

    public Persona(Identity.SuperEgo id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }

}
