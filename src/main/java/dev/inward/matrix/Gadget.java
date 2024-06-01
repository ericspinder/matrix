package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.Addressed;

import java.util.UUID;

public abstract class Gadget<S extends Scheme<S,L>,L extends Library<S,L>,D extends Dogma<S,L,D>,A extends Gadget.Address<S,L,D,A,G>,G extends Gadget<S,L,D,A,G>> implements Addressed<S,L,D,String,A,G> {

    protected final A identity;

    public Gadget(A identity) {
        this.identity = identity;
    }
    @Override
    public A getIdentity() {
        return this.identity;
    }

    @Override
    public int compareTo(G o) {
        return 0;
    }
    public static class Pathway<S extends Scheme<S,L>,L extends Library<S,L>> extends dev.inward.matrix.Pathway<S,L,Dogma.Agent<S,L>> {

        protected Pathway(char sigil, Dogma.Agent<S, L> slAgent) {
            super(sigil, slAgent);
        }

        @Override
        public L getLibrary() {
            return null;
        }

        @Override
        public int compareTo(dev.inward.matrix.Pathway<S, L, Dogma.Agent<S, L>> o) {
            return 0;
        }
    }

    public static class Address<S extends Scheme<S,L>,L extends Library<S,L>,D extends Dogma<S,L,D>,A extends Address<S,L,D,A,G>,G extends Gadget<S,L,D,A,G>> extends Identity<S,L,D,String,A,G>  {

        protected final UUID instance;
        protected final D dogma;
        public Address(String name,UUID instance, D dogma) {
            super(name);
            this.instance = instance;
            this.dogma = dogma;
        }

        @Override
        public S getScheme() {
            return this.dogma.getIdentity().getScheme();
        }

        @Override
        public Terrene getTerrene() {
            return this.dogma.getIdentity().getTerrene();
        }

        @Override
        public Domain getDomain() {
            return this.dogma.getIdentity().getDomain();
        }

        @Override
        public Pathway<S, L, D> getPathway() {
            return null;
        }

        @Override
        public String toString() {
            return null;
        }

        @Override
        public int compareTo(A o) {
            return 0;
        }
    }
}
