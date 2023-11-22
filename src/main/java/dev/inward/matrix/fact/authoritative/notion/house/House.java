package dev.inward.matrix.fact.authoritative.notion.house;

import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.authoritative.notion.Notion;

import java.nio.file.Path;
import java.nio.file.attribute.GroupPrincipal;

public abstract class House<S extends Scheme<S,L>,L extends Library<S,L>,H extends House<S,L,H>> extends Concept<S,L,H, Domain,Identity.Tangible.Brand<S,L,H>,H> implements GroupPrincipal {

    public House(Identity.Tangible.Brand<S,L,H> brand) {
        super(brand);
    }

}
