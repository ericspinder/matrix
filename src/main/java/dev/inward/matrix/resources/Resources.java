package dev.inward.matrix.resources;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat.Startup;
import dev.inward.matrix.policy.Policy;

import java.util.HashMap;
import java.util.Map;

public abstract class Resources<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>,O extends Operational<F,I,ID,X>> extends Resource<F,F,I,ID,X> {

    private Supplier supplier;
    private final Map<String,? super Resource<?,F,I,ID,X>> datumMap = new HashMap<>();

    public Resources(Policy[] policies) {
        super(policies);
    }

    @SuppressWarnings("unchecked")
    public <DATUM> Resource<DATUM,F,I,ID,X> getResource(Class<DATUM> datumClass) {
        Resource<DATUM,F,I,ID,X> resource = (Resource<DATUM,F,I,ID,X>) datumMap.get(datumClass.getCanonicalName());
        if (resource == null) {
            datumMap.put(Startup.root().get().newResource(datumClass)
        }
    }


}
