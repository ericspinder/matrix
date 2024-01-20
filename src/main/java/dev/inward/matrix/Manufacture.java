package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.datum.User;
import dev.inward.matrix.personality.Persona;

public abstract class Manufacture<S extends Scheme<S,L>,L extends Library<S,L>,E extends Identity.Ethereal<S,L,E,M>,M extends Manufacture<S,L,E,M>> implements Addressed<S,L,Character,String,E,M> {

    protected final E identity;

    public Manufacture(E identity) {
        this.identity = identity;
    }
    @Override
    public E getIdentity() {
        return this.identity;
    }

    @Override
    public int compareTo(M that) {
        return this.identity.compareTo(that.identity);
    }
}
