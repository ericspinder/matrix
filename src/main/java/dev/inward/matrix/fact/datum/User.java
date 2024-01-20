package dev.inward.matrix.fact.datum;

import dev.inward.matrix.*;
import dev.inward.matrix.personality.Persona;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.Subject;
import java.nio.file.attribute.UserPrincipal;

public abstract class User<S extends Scheme<S,L>,L extends Library<S,L>,E extends Identity.Ethereal<S,L,E,U>,U extends User<S,L,E,U>> extends Manufacture<S,L,E,U> implements UserPrincipal {


    public User(E identity) {
        super(identity);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return UserPrincipal.super.implies(subject);
    }
}
