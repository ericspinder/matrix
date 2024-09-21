package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Rider;
import dev.inward.matrix.personality.Personality;

import java.nio.file.Path;
import java.security.Principal;
import java.security.ProtectionDomain;

public class Context<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C,R>,C extends Concept<PATH,P,ID,T,C,R>,R extends Rider<PATH,P,ID,T,C,R>> extends ProtectionDomain {

    protected final P pathway;
    public Context(Variant<PATH,P,ID,T,C> variant,
                   Personality personality,
                   Factory<PATH,P,ID,T,C> factory,
                   Dogma.Agent owner, Dogma.House group,P pathway) {
        super(variant,personality,factory,new Principal[] {owner,group});
        this.pathway = pathway;
    }

    public P getPathway() {
        return this.pathway;
    }
    @SuppressWarnings("unchecked")
    public Variant<PATH,P,ID,T,C> getVariant() {
        return (Variant<PATH,P,ID,T,C>) this.getCodeSource();
    }
    @SuppressWarnings("unchecked")
    public Personality<S,L,?> getPersonality() {
        return (Personality<S,L,?>)this.getPermissions();
    }
    @SuppressWarnings("unchecked")
    public Factory<PATH,P,ID,T,C> getFactory() {
        return (Factory<PATH,P,ID,T,C>) this.getClassLoader();
    }

}
