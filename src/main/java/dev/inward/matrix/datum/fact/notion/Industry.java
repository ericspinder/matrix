package dev.inward.matrix.datum.fact.notion;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.util.Map;

public abstract class Industry<Y extends Industry<Y,N,S,I,X,O,P,C,M>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P,C,M>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P,C,M>,P extends Primogenitor<Y,N,S,I,X,O,P,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Factory<Y,N,S,I,X,O,P,C,M> {


    public Industry(M mortal, Map<Class<?>, Resource<Y,?,?,N, S, I, X, O, P, N, P,?>> classResourceMap) {
        super(mortal, classResourceMap);
    }
}
