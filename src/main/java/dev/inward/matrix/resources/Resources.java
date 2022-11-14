package dev.inward.matrix.resources;

import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.policy.Policy;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.house.ziggurat.Startup;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.HashMap;
import java.util.Map;

public final class Resources<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>> extends Resource<F> {

    private Supplier<?,F,I,X,R,NI,NX> supplier;
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
