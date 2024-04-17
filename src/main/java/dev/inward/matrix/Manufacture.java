package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;

public abstract class Manufacture<S extends Scheme<S,L>,L extends Library<S,L>,M extends Manufacture<S,L,M>> implements Addressed<S,L,Character,String, Dogma.Ethereal<S,L,M>,M> {

    protected final Dogma.Ethereal<S,L,M> identity;

    public Manufacture(Dogma.Ethereal<S,L,M> identity) {
        this.identity = identity;
    }
    @Override
    public Dogma.Ethereal<S,L,M> getIdentity() {
        return this.identity;
    }

    @Override
    public int compareTo(M that) {
        return this.identity.compareTo(that.identity);
    }
}
