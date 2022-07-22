package dev.inward.matrix.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Diplomat;
import dev.inward.matrix.fact.notion.concept.*;

import java.lang.ref.ReferenceQueue;

public class LifeGuard<I extends Identity<I,X>,X extends Context<X>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Diplomat<Submariner<I,X,FAB,C,T,V,M>,Pool<I,X>,Pump<I,X,FAB,C,T,V,M>,I,X,Skimmer<I,X,FAB,C,T,V,M>,LifeGuard<I,X,FAB,C,T,V,M>> {

    public LifeGuard(Pool<I, X> fact, ReferenceQueue<Pool<I, X>> referenceQueue, Skimmer<I, X, FAB, C, T, V, M> bus, Pump<I, X, FAB, C, T, V, M> operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
