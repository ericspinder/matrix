package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.Agent.Version;
import dev.inward.matrix.clues.Clue;
import dev.inward.matrix.clues.Clues;

import java.io.Serializable;

public abstract class Context<X extends Context<X>> implements Comparable<X>, Serializable {

    protected final boolean production;
    protected final Edition edition;
    protected final Clues<X> clues;
    public Context() {
        this(new Edition(Version.Aforementioned),true,new Clues<>());
    }
    public Context(Edition edition, boolean production, Clues<X> clues) {
        this.edition = edition;
        this.production = production;
        this.clues = clues;
    }

    public Edition getEdition() {
        return this.edition;
    }
    public boolean isProduction() {
        return this.production;
    }

    public static class Service extends Platform<Service> {

        protected final String name;
        public Service(String name) {
            super();
            this.name = name;
        }
        public Service(Edition edition, boolean production, Clues<Service> clues, String name) {
            super(edition, production, clues);
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static class JVM extends Platform<JVM> {
        public JVM() {
            super();
        }
        public JVM(Edition edition, boolean production, Clues<JVM> clues) {
            super(edition,production,clues);
        }
    }
    public static abstract class Platform<X extends Platform<X>> extends Context<X> {
        public Platform() {
            super();
        }
        public Platform(Edition edition, boolean production, Clues<X> clues) {
            super(edition, production,clues);
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

    public <EXHIBIT,CLUE extends Clue<X,EXHIBIT>> CLUE  getClue(Class<CLUE> clueClass)  {
        return clues.get(clueClass, (X)this);
    }
}
