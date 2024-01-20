package dev.inward.matrix;

import dev.inward.matrix.fact.datum.Coterie;
import dev.inward.matrix.fact.datum.User;
import dev.inward.matrix.personality.Persona;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class Directory<S extends Scheme<S,L>,L extends Library<S,L>,P extends Persona<S,L,P>> extends UserPrincipalLookupService {


    @Override
    public User<S,L,?,?> lookupPrincipalByName(String name) throws IOException {
        return null;
    }

    @Override
    public Coterie<S,L> lookupPrincipalByGroupName(String group) throws IOException {
        return null;
    }
}
