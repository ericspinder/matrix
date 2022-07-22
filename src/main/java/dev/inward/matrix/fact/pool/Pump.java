package dev.inward.matrix.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.*;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Pump<I extends Identity<I,X>,X extends Context<X>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Operational<Submariner<I,X,FAB,C,T,V,M>,Pool<I,X>,Pump<I,X,FAB,C,T,V,M>,I,X,Skimmer<I,X,FAB,C,T,V,M>,LifeGuard<I,X,FAB,C,T,V,M>> {
    public Pump(Specification specification, Supplier<Submariner<I, X, FAB, C, T, V, M>, Pool<I, X>, Pump<I, X, FAB, C, T, V, M>, I, X, Skimmer<I, X, FAB, C, T, V, M>, LifeGuard<I, X, FAB, C, T, V, M>, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
