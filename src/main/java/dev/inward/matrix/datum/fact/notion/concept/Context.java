package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.clues.Clue;
import dev.inward.matrix.clues.Clues;

public abstract class Context<X extends Context<X>> {

    protected final boolean production;
    protected final Clues<X> clues;
    public Context() {
        this(true,new Clues<>());
    }
    public Context(boolean production, Clues<X> clues) {
        this.production = production;
        this.clues = clues;
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
        public Service(boolean production, Clues<Service> clues, String name) {
            super(production, clues);
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
        public JVM(boolean production, Clues<JVM> clues) {
            super(production,clues);
        }
    }
    public static abstract class Platform<X extends Platform<X>> extends Context<X> {
        public Platform() {
            super();
        }
        public Platform(boolean production, Clues<X> clues) {
            super(production,clues);
        }
    }

    public <EXHIBIT,CLUE extends Clue<X,EXHIBIT>> CLUE  getClue(Class<CLUE> clueClass)  {
        return clues.get(clueClass, (X)this);
    }
}
