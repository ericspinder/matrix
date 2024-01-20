package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;

import java.nio.file.attribute.GroupPrincipal;

public abstract class Coterie<S extends Scheme<S,L>,L extends Library<S,L>,C extends Coterie<S,L,C>> extends User<S,L, Identity.Ethereal.Ego<S,L,C>,C> implements GroupPrincipal {

    public Coterie(Identity.Ethereal.Ego<S, L, C> superEgo) {
        super(superEgo);
    }
}
