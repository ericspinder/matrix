package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.resources.Resource;

import java.io.Serializable;
import java.lang.invoke.CallSite;
import java.lang.ref.SoftReference;
import java.util.UUID;

public class Envoy<DATUM,E extends Envoy<DATUM,E,S,L,PATH,ID,T,C>,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends SoftReference<DATUM> {

    public Envoy(DATUM datum, Resource<DATUM,S,L,PATH,ID,T,C> resource) {
        super(datum, resource);
        if (resource.increment()) {
            doIncrementFailure(datum,resource);
        }
    }
    protected void doIncrementFailure(DATUM datum, Resource<DATUM,S,L,PATH,ID,T,C> resource) {
        Matrix
    }

}