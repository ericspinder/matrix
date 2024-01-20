package dev.inward.matrix.fact;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;

public abstract class Fact<S extends Scheme<S,L>,L extends Library<S,L>,N extends Identity.Tangible.Named<S,L,N,F>,F extends Fact<S,L,N,F>> extends Concept<S,L,String,String,N,F> {


    protected final short fidelity;

    public Fact(N identity, short fidelity) {
        super(identity);
        this.fidelity = fidelity;
    }

    public short getFidelity() {
        return fidelity;
    }


}
