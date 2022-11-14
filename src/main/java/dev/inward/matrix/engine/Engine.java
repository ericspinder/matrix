package dev.inward.matrix.engine;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;

import java.time.Instant;
import java.util.*;

public class Engine<Y extends Factory<Y,F,I,X,R>,F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O,?,?>,B extends Bus<F,I,X,B,R,N,NI,NX,A,U,T>,R extends Representative<F,I,X,R,NI,NX>,D extends Model<F,I,X,?,?,R,?,?,?>,N extends Notion<N,NI,NX,?,?,?>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,U extends Route<F,I,X,B,R,N,NI,NX,A,U>,S extends Resources<F,I,X,R,NI,NX>> {

    public final Instant createInstant = Instant.now();
    protected List<Model<F,I,X,O,B,R,?,?,?,?>> modelList = new ArrayList<>();
    protected final Map<String,Induction<Y,F,O,I,X,B,R,N,NI,NX,A,>> inductionMap = new HashMap<>();


    public Engine(O operational, S resources) {
        this.operational = operational;
        this.operational.specification().getStandards(resources.)
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
