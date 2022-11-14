package dev.inward.matrix.personality;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Indicia;

import javax.security.auth.Subject;
import java.security.CodeSigner;
import java.security.Principal;
import java.util.concurrent.ConcurrentHashMap;

public class Persona implements Principal {

    protected CodeSigner codeSigner;
    protected ConcurrentHashMap<Indicia, Identity.SuperEgo> matterCollectors;
    protected Identity.SuperEgo defaultCollector;

    public Persona(CodeSigner codeSigner, ConcurrentHashMap<Indicia,Identity.SuperEgo> matterCollectors, Identity.SuperEgo defaultCollector) {
        this.codeSigner = codeSigner;
        this.matterCollectors = matterCollectors;
        this.defaultCollector = defaultCollector;
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
        return this.matterCollectors.getOrDefault(indicia,defaultCollector);
    }

}
