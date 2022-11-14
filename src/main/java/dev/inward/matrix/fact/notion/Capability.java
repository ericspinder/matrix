package dev.inward.matrix.fact.notion;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.resources.NotionProtectionDomain;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Envoy;

public class Capability<Y extends Industry<Y,N,S,I,X,O,A>,DATUM,D extends Datum<DATUM,D,V,I,X>,V extends Envoy<DATUM,D,V,I,X>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Resource<DATUM,D,V,N,I,X,A,I,X> {
    /**
     * @param notionProtectionDomain
     * @noinspection Intellij
     */
    public Capability(NotionProtectionDomain notionProtectionDomain) {
        super(notionProtectionDomain);
    }
}
