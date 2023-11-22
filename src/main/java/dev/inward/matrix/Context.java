package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.personality.Personality;

import java.security.ProtectionDomain;

public class Context<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> extends ProtectionDomain {

    protected final CAT catalog;
    public Context(Variant<S,L,PATH> variant,
                   Personality personality,
                   Factory<S,L,PATH,ID,T,C> factory,
                   ) {
        super(variant,personality,factory,factory.getCatalog());
    }



}
