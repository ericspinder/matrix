package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

import java.util.LinkedHashMap;
import java.util.Map;

public class Memory<Y extends Industry<Y,N,S,I,X,O,A,C,M>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A,C,M>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A,C,M>,A extends Ambassador<Y,N,S,I,X,O,A,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends LinkedHashMap<X,A> {



    @Override
    protected boolean removeEldestEntry(Map.Entry<X, A> eldest) {
        return super.removeEldestEntry(eldest);
    }
}
