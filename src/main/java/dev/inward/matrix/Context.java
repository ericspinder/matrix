package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.personality.Personality;

import java.security.ProtectionDomain;

public class Context<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> extends ProtectionDomain {

    protected final CAT catalog;
    public Context(Variant<S,L> variant,
                   Personality personality,
                   Factory<S,L,PATH,ID,T,C> factory,
                   Dogma.Agent[] owners,
                   CAT catalog
                   ) {
        super(variant,personality,factory,owners);
        this.catalog = catalog;
    }

    public CAT getCatalog() {
        return catalog;
    }
    @SuppressWarnings("unchecked")
    public Variant<S,L> getVariant() {
        return (Variant<S,L>) this.getCodeSource();
    }
    @SuppressWarnings("unchecked")
    public Personality<S,L,?> getPersonality() {
        return (Personality<S,L,?>)this.getPermissions();
    }
    @SuppressWarnings("unchecked")
    public Factory<S,L,PATH,ID,T,C> getFactory() {
        return (Factory<S,L,PATH,ID,T,C>) this.getClassLoader();
    }

}
