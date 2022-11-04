package dev.inward.matrix.resources;

import dev.inward.matrix.clues.Policy;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Operational;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Startup;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.HashMap;
import java.util.Map;

public final class Resources<F extends Fact<F,I,X>,O extends Operational<F,O,I,X,N,NI,NX,M,T>,I extends Identity<I,X>,X extends Context<X>,N extends Notion<N,I,X>,NI extends Identity<NI,NX>,NX extends Context<NX>,B extends Bus<F,O,I,X,B,N,NI,NX,M,T>,M extends Matter<M,I,X>,P extends Phenomenon<M,P,T>,T extends Tolerances<M,T>> extends Resource<F> {

    private Supplier<?,F,O,I,X,B,?,N,NI,NX,M,P,T> supplier;
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
