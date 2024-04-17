package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Dogma;

import javax.security.auth.Subject;

public class Individual<S extends Scheme<S,L>,L extends Library<S,L>> extends Dogma<S,L, Individual<S,L>> {



    public Individual(Ethereal<S,L, User<S,L>> ethereal) {
        super(ethereal);
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }

    @Override
    public int compareTo(User<S, L> o) {
        return 0;
    }
}
