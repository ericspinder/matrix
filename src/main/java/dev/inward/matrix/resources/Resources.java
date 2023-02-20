package dev.inward.matrix.resources;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat.Startup;
import dev.inward.matrix.policy.Policy;

import java.util.HashMap;
import java.util.Map;

public class Resources<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> extends Resource<F> {

    private Supplier supplier;
    private final Map<String,? super Resource<?>> datumMap = new HashMap<>();

    public Resources(Policy[] policies) {
        super(policies);
    }

    @SuppressWarnings("unchecked")
    public <DATUM> Resource<DATUM> getResource(Class<DATUM> datumClass) {
        Resource<DATUM> resource = (Resource<DATUM>) datumMap.get(datumClass.getCanonicalName());
        if (resource == null) {
            datumMap.put(Startup.root().get().newResource(datumClass)
        }
    }


}
