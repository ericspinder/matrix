package dev.inward.matrix.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.concept.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Submariner<I extends Identity<I,X>,X extends Context<X>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Factory<Submariner<I,X,FAB,C,T,V,M>,Pool<I,X>,Pump<I,X,FAB,C,T,V,M>,I,X,Skimmer<I,X,FAB,C,T,V,M>,LifeGuard<I,X,FAB,C,T,V,M>,FAB,C,T,V,M> {


    public Submariner(M mortal, Resources resources, Map<Standard<?, Pool<I, X>, I, X>, Resource<Submariner<I, X, FAB, C, T, V, M>, ?, ?, ?, Pool<I, X>, Pump<I, X, FAB, C, T, V, M>, I, X, Skimmer<I, X, FAB, C, T, V, M>, LifeGuard<I, X, FAB, C, T, V, M>>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }

    @Override
    public int compareTo(Submariner that) {
        return this.uuid.compareTo(that.uuid);
    }

}
