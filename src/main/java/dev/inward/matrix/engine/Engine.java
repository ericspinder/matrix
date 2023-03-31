package dev.inward.matrix.engine;

import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;

import java.time.Instant;
import java.util.*;

public class Engine<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>,O extends Operational<F,I,ID,X>,S extends Resources<F,I,ID,X>> {

    public final Instant createInstant = Instant.now();
    protected final O operational;
    protected List<Model<F,I,X,O,B,R,?,?,?,?>> modelList = new ArrayList<>();
    protected final Map<String,Induction<Y,F,O,I,X,B,R,N,NI,NX,A,>> inductionMap = new HashMap<>();


    public Engine(O operational, S resources) {
        this.operational = operational;
        this.operational.specification().getStandards(resources)
        Arrays.stream(operational.specification).forEach(i ->this.inductionMap.put(i.getDatumClassName(),i));
    }

    public O getOperational() {
        return operational;
    }

    public <DATUM,D extends Datum<DATUM,D>> Envoy<DATUM,D,?> buildEnvoy(DATUM datum) {
        Induction<> induction = (Induction<Y,DATUM,D,V,F,I,X,>) operational.specification().getStandards().get(datum.getClass());
        return induction.createEnvoy(datum,factory
        );
    }
    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> V add(DATUM datum) {
        try {
            Resource<DATUM> resource = (Resource<DATUM>) this.producer.get(((D) datum).getClass());
            return this.defineClass()add(datum,this);
        }
        catch (ClassCastException cce) {

        }


//        for (Predictor<Y,?,F,O,I,X,B,P,?,?,?> predictor: predictorMap.keySet()) {
//            predictor.registerCriterion()
//        }
        return null;
    }
}
