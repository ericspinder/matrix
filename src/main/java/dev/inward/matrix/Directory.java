package dev.inward.matrix;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;

public class Directory<S extends Scheme<S,L>,L extends Library<S,L>,P extends Dogma.Persona<S,L,P>> extends UserPrincipalLookupService {


    @Override
    public Dogma<S,L,?,?> lookupPrincipalByName(String name) throws IOException {
        return null;
    }

    @Override
    public Dogma.House<S,L> lookupPrincipalByGroupName(String group) throws IOException {
        return null;
    }
}
