package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.Agent.Agent;

import java.io.Serializable;

public abstract class Context<X extends Context<X>> implements Comparable<X>, Serializable {

    protected final boolean production;
    protected final Edition edition;

    public Context(Edition edition, boolean production) {
        this.edition = edition;
        this.production = production;
    }

    public Edition getEdition() {
        return this.edition;
    }
    public boolean isProduction() {
        return this.production;
    }

    public static class Service extends Platform<Service> {

        protected final String name;
        public Service(Edition edition, boolean production, String name) {
            super(edition, production);
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static class JVM extends Platform<JVM> {
        public JVM(Edition edition, boolean production) {
            super(edition,production);
        }
    }
    public static abstract class Platform<X extends Platform<X>> extends Context<X> {

        public Platform(Edition edition, boolean production) {
            super(edition, production);
        }
    }

    @Override
    public int compareTo(X that) {
        int isZero  = this.edition.compareTo(that.edition);
        if (isZero == 0 && this.production == that.production) {
            return 0;
        }
        else if (production) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
