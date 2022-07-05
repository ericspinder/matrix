package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.agent.Edition;
import dev.inward.matrix.clues.Clue;
import dev.inward.matrix.clues.Clues;

public abstract class Context<X extends Context<X>> implements Comparable<X> {

    protected final boolean production;
    protected final Edition edition;
    protected final Clues<X> clues;
    public Context(Edition<?> edition, boolean production, Clues<X> clues) {
        this.edition = edition;
        this.production = production;
        this.clues = clues;
    }

    public boolean isProduction() {
        return this.production;
    }

    public static class Service extends Platform<Service> {

        protected final String name;
        public Service(Edition edition, boolean production, Clues<Service> clues, String name) {
            super(edition, production, clues);
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static class JVM extends Platform<JVM> {
        public JVM(Edition<?> edition, boolean production, Clues<JVM> clues) {
            super(edition,production,clues);
        }
    }
    public static class Platform<X extends Platform<X>> extends Context<X> {
        public Platform(Edition<?> edition, boolean production, Clues<X> clues) {
            super(edition, production,clues);
        }
    }

    public <EXHIBIT,CLUE extends Clue<EXHIBIT>> CLUE  getClue(Class<CLUE> clueClass)  {
        return clues.get(clueClass);
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
            return this.getClue(dev.inward.matrix.clues.TestName.class).getExhibit().compareTo(that.getClue(dev.inward.matrix.clues.TestName.class).getExhibit());
        }
        return isZero;
    }
    public final Edition getEdition() {
        return this.edition;
    }
}
