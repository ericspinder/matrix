package dev.inward.matrix.resources;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Startup;
import dev.inward.matrix.policy.Policy;

import java.util.HashMap;
import java.util.Map;

public abstract class Resources<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Resource<C,S,L,PATH,ID,T,C> {

    private Supplier supplier;
    private final Map<String,? super Resource<?,S,L,PATH,C>> datumMap = new HashMap<>();

    public Resources(Policy[] policies) {
        super(policies);
    }

    @SuppressWarnings("unchecked")
    public <DATUM> Resource<DATUM,S,L,PATH,F> getResource(Class<DATUM> datumClass) {
        Resource<DATUM,S,L,PATH,F> resource = (Resource<DATUM,S,L,PATH,F>) datumMap.get(datumClass.getCanonicalName());
        if (resource == null) {
            datumMap.put(Startup.root().get().newResource(datumClass)
        }
    }


}
