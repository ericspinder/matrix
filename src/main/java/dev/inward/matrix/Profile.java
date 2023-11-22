package dev.inward.matrix;

import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.datum.User;

import java.nio.file.Path;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.GroupPrincipal;

public abstract class Profile<S extends Scheme<S,L>,L extends Library<S,L>, P extends Profile<S,L,P,U>,U extends User<S,L,U>> extends Concept<S,L,Path,String, Identity.Tangible.SuperEgo<S,L,P,U>, P> implements GroupPrincipal {

    protected final Map<U, AclEntryType>
    public Profile(Identity.Tangible.SuperEgo<S,L, P,U> identity) {
        super(identity);
    }
}
