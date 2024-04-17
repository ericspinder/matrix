package dev.inward.matrix.resources;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Startup;
import dev.inward.matrix.policy.Policy;

import java.util.HashMap;
import java.util.Map;

public abstract class Resources<S extends Scheme<S,L>,L extends Library<S,L>,N extends Fact.Named<S,L,N,F>,F extends Fact<S,L,N,F>> extends Contrivance<S,L,String,String,N,F,N,F> {

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
