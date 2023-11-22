package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.setting.MagicWord;

import java.nio.file.attribute.UserPrincipal;
import java.security.Permission;

public abstract class User<S extends Scheme<S,L>,L extends Library<S,L>,U extends User<S,L,U>> extends Concept<S,L,String,String,Identity.Tangible.Individual<S,L,U>,U> implements UserPrincipal {

    protected final MagicWord[] magicWords;

    public User(Identity.Tangible.Individual<S,L,U> profile, MagicWord[] magicWords) {
        super(profile);
        this.magicWords = magicWords;
    }

}
