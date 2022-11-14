package dev.inward.matrix.engine;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.*;
import dev.inward.matrix.fact.notion.concept.Context;

import java.util.LinkedHashMap;
import java.util.Map;

public class Memory<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends LinkedHashMap<X,A> {

    @Override
    protected boolean removeEldestEntry(Map.Entry<X, A> eldest) {
        return super.removeEldestEntry(eldest);
    }
}
