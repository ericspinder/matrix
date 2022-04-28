package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.util.LinkedHashMap;
import java.util.Map;

public class Memory<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P>,P extends Primogenitor<Y,N,S,I,X,O,P>> extends LinkedHashMap<X,P> {

    @Override
    protected boolean removeEldestEntry(Map.Entry<X, P> eldest) {
        return super.removeEldestEntry(eldest);
    }
}
