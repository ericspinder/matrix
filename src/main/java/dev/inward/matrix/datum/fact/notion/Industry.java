package dev.inward.matrix.datum.fact.notion;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.util.Map;

public abstract class Industry<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P>,P extends Primogenitor<Y,N,S,I,X,O,P>> extends Factory<Y,N,S,I,X,O,P,N,P> {


    public Industry(P primogenitor, Map<Class<?>, Resource<Y, ?, N, S, I, X, O, P, N, P, ?>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }
}
