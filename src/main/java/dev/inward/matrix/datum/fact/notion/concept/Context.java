package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.edition.Edition;
import dev.inward.matrix.domain.Domain;

public abstract class Context<X extends Context<X>> implements Comparable<X> {

    protected final boolean production;
    protected final Edition edition;
    protected final Domain domain;

    public Context(Edition edition, boolean production,Domain domain) {
        this.edition = edition;
        this.production = production;
        this.domain = domain;
    }

    public Domain getDomain() {
        return domain;
    }

    public boolean isProduction() {
        return this.production;
    }

    public static class Service extends Platform<Service> {

        protected final String name;
        public Service(Edition edition, boolean production, Domain domain, String name) {
            super(edition, production, domain);
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static class Ethereal extends Platform<Ethereal> {
        public Ethereal(Edition edition, boolean production, Domain domain) {
            super(edition,production,domain);
        }
    }
    public static class Platform<X extends Platform<X>> extends Context<X> {
        public Platform(Edition edition, boolean production,Domain domain) {
            super(edition, production,domain);
        }
    }
    public static class Character<X extends Character<X>> extends Context<X> {

        protected char character;

        public Character(Edition edition, boolean production,Domain domain, char character) {
            super(edition,production,domain);
            this.character = character;
        }
    }
    public static class Web extends Character<Web> {
        public Web(Edition edition, boolean production,Domain domain) {
            super(edition,production,domain,'/');
        }
    }
    public static class Home extends Character<Web> {
        public Home(Edition edition, boolean production,Domain domain) {
            super(edition,production,domain,'~');
        }
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
        }
        return isZero;
    }
    public final Edition getEdition() {
        return this.edition;
    }
}
