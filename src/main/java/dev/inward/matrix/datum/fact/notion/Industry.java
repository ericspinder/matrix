package dev.inward.matrix.datum.fact.notion;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public abstract class Industry<Y extends Industry<Y,N,S,I,X,O,A,FAB,C,E,V,M>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Ambassador<Y,N,S,I,X,O,A>,FAB extends Fabrication<FAB,C,E,V,M>,C extends Concept<C,M>,E extends Effect<FAB,C,E,V,M>,V extends Volume<FAB,C,E,V,M>,M extends Mortal<FAB,C,E,V,M>> extends Factory<Y,N,S,I,X,O,A,FAB,C,E,V,M> {

    public Industry(M mortal, Resources resources, Map<Standard<?, N, I, X>, Resource<Y, ?, ?, ?, N, S, I, X, O, A>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
