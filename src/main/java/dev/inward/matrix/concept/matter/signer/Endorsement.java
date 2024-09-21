package dev.inward.matrix.concept.matter.signer;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;

import java.time.Instant;

public class Endorsement<S extends Scheme<S,L>,L extends Library<S,L>> extends Sacrosanct<S,L,Endorsement<S,L>> {

    public Endorsement(Id<S, L, Endorsement<S, L>, Instant> id, Instant[] instants) {
        super(id, instants);
    }

}
