package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.agent.Edition;
import dev.inward.matrix.clues.Rule;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.policy.Clue;
import dev.inward.matrix.domain.Domain;

import java.util.HashMap;

public abstract class Context<X extends Context<X>> implements Comparable<X> {

    protected final boolean production;
    protected final Edition edition;
    protected final Domain domain;

    public Context(Edition edition, boolean production,Domain domain) {
        this.edition = edition;
        this.production = production;
        this.domain = domain;
    }

    public boolean isProduction() {
        return this.production;
    }

    public static class  Service extends Platform<Service> {

        protected final String name;
        public Service(Edition edition, boolean production, Domain domain, String name) {
            super(edition, production, domain);
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static class JVM extends Platform<JVM> {
        public JVM(Edition edition, boolean production, Domain domain) {
            super(edition,production,domain);
        }
    }
    public static class Platform<X extends Platform<X>> extends Context<X> {
        public Platform(Edition edition, boolean production,Domain domain) {
            super(edition, production,domain);
        }
    }

    public <PRACTICE,RULE extends Rule<PRACTICE,RULE>> RULE getRule(Class<RULE> ruleClass, Effect effect, Identity.SuperEgo superEgo)  {


    }
    public int compareTo(X that) {
        int isZero = this.edition.compareTo(that.edition);
        if (isZero == 0) {
            if (this.production && that.production) {
                return 0;
            }
            if (this.production) {
                return 1;
            }
            return this.getClue(dev.inward.matrix.policy.TestName.class).getExhibit().compareTo(that.getClue(dev.inward.matrix.policy.TestName.class).getExhibit());
        }
        return isZero;
    }
    public final Edition getEdition() {
        return this.edition;
    }
}
