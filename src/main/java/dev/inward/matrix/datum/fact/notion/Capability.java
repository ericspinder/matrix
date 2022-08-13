package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.NotionProtectionDomain;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

public class Capability<Y extends Industry<Y,N,S,I,X,O,A,?,?,?,?,?>,DATUM,D extends Datum<DATUM,D,V,N,I,X,A>,V extends Envoy<DATUM,D,V,N,I,X,A>,N extends Notion<N,I,X>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends dev.inward.matrix.datum.fact.Diplomat<Y, N, S, I, X, O, A>> extends Resource<Y,DATUM,D,V,N,S,I,X,O,A> {
    /**
     * @param notionProtectionDomain
     * @noinspection Intellij
     */
    public Capability(NotionProtectionDomain notionProtectionDomain) {
        super(notionProtectionDomain);
    }
}
