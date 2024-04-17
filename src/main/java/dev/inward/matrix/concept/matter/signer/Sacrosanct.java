package dev.inward.matrix.concept.matter.signer;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Matter;

import java.time.Instant;

public class Sacrosanct<S extends Scheme<S,L>,L extends Library<S,L>, SACROSANCT extends Sacrosanct<S,L,SACROSANCT>> extends Matter<S,L,SACROSANCT, Instant> {

    public Sacrosanct(Rubric<S, L, SACROSANCT, Instant> rubric, Instant[] instants) {
        super(rubric, instants);
    }

    @Override
    public boolean isSettled() {
        return true;
    }



}
