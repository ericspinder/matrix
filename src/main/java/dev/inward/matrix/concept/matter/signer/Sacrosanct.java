package dev.inward.matrix.concept.matter.signer;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Matter;

import java.time.Instant;

public class Sacrosanct<S extends Scheme<S,L>,L extends Library<S,L>, SACROSANCT extends Sacrosanct<S,L,SACROSANCT>> extends Matter<S,L,SACROSANCT, Instant> {

    public Sacrosanct(Id<S, L, SACROSANCT, Instant> id, Instant[] instants) {
        super(id, instants);
    }

    @Override
    public boolean isSettled() {
        return true;
    }



}
