package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Indicia;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.concurrent.ConcurrentHashMap;

public final class Persona extends Notion<Persona, Identity.SuperEgo,Context.Service,Spirit> implements Principal {

    protected ConcurrentHashMap<Indicia, Identity.SuperEgo> matterCollectors;

    public Persona(Identity.SuperEgo id, ConcurrentHashMap<Indicia,Identity.SuperEgo> matterCollectors,) {
        super(id);
        this.matterCollectors = matterCollectors;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }

    public Identity.SuperEgo getMatterCollector(Indicia indicia) {
        this.matterCollectors.getOrDefault(indicia,);
        if (this.matterCollectors.containsKey(indicia)) {
            return this.matterCollectors.get(indicia)
        }
    }
}
