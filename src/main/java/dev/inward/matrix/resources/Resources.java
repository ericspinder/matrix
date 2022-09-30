package dev.inward.matrix.resources;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class Resources<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Resource<N,N,A,N,I,X,A> {

    protected final NotionProtectionDomain<Y,N,S,I,X,O,A> notionProtectionDomain;
    protected final Map<Standard, Resource> standardResourcesMap;

    public Resources(NotionProtectionDomain<Y, N, S, I, X, O, A> notionProtectionDomain, Map<Standard, Resource> standardResourcesMap) {
        this.notionProtectionDomain = notionProtectionDomain;
        this.standardResourcesMap = standardResourcesMap;
    }

}
