package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.personality.Personality;
import dev.inward.matrix.personality.Personas;

import java.util.Map;

public abstract class Notion<PATH extends Comparable<PATH>,S extends Notion.Pathway<PATH,S>,ID extends Comparable<ID>,I extends Notion.Id<PATH,S,ID,I,N>,N extends Notion<PATH,S,ID,I,N>> implements Addressed<PATH,S,ID,I,N> {

    public static class Id<PATH extends Comparable<PATH>,P extends Notion.Pathway<PATH,P>,ID extends Comparable<ID>,I extends Notion.Id<PATH,P,ID,I,N>,N extends Notion<PATH,P,ID,I,N>> implements Identity<PATH,P,ID,I,N> {

        @Override
        public ID getId() {
            return null;
        }

        @Override
        public PATH getPath() {
            return null;
        }

        @Override
        public N get() {
            return null;
        }

        @Override
        public int compareTo(I o) {
            return 0;
        }
    }
    public static class Pathway<PATH extends Comparable<PATH>,S extends Pathway<PATH,S>> implements Directory<PATH,S> {

        @Override
        public Administration getAdministration() {
            return null;
        }

        @Override
        public Ledger<PATH, S> getLedger() {
            return null;
        }

        @Override
        public PATH getPath() {
            return null;
        }

        @Override
        public int compareTo(S o) {
            return 0;
        }
    }
    public static class Administration<PATH,> implements dev.inward.matrix.Administration

    public Notion(Tangible.Gate<S,L> id) {
        super(id);
    }


}
