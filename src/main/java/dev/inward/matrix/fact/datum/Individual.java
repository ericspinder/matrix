package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.personality.Persona;

import javax.security.auth.Subject;

public class Individual<S extends Scheme<S,L>,L extends Library<S,L>> extends User<S,L, Identity.Ethereal.SuperEgo<S,L>, Individual<S,L>> {


    public Individual(Identity.Ethereal.SuperEgo<S, L> superEgo) {
        super(superEgo);
    }

    @Override
    public String getName() {
        return this.identity.;
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }
}
