package dev.inward.matrix.personality;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.security.Permission;

public class Psyche<N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>> extends Permission {

    protected final String description;

    public Psyche(String name, String description) {
        super(name);
        this.description = description;
        this.checkGuard();
    }

    public boolean implies(Psyche psyche) {

    }
    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof Psyche) {
            return implies((Psyche) permission);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getActions() {
        return this.description;
    }
    public String getDescription() {
        return this.description;
    }
}
