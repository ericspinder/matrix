package dev.inward.matrix.resources;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.*;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Standard;

import java.util.HashMap;
import java.util.Map;

public class Storage<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Resources<N,I,X,A,I,X> {

    protected final NotionProtectionDomain<Y,N,S,I,X,O,A> notionProtectionDomain;
    protected final Map<String, Resource> standardResourcesMap = new HashMap<>();

    public Storage(NotionProtectionDomain<Y, N, S, I, X, O, A> notionProtectionDomain, Map<Standard, Resource> standardResourcesMap) {
        this.notionProtectionDomain = notionProtectionDomain;
        this.standardResourcesMap = standardResourcesMap;
    }

}
