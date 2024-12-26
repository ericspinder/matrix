package dev.inward.matrix.engine;

import dev.inward.matrix.*;
import dev.inward.matrix.Pathway;
import dev.inward.matrix.Envoy;

import java.time.Instant;
import java.util.*;

public class Engine<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>> {

    public final Instant createInstant = Instant.now();
    protected final Operational<PATH,ID,I,A,R,F> operational;
    protected final Map<String,Induction<>> inductionMap = new HashMap<>();


    public Engine(Operational<PATH,ID,I,A,R,F> operational, Addressed.Resource<PATH,ID,I,A,R,F> resources) {
        this.operational = operational;
        resources.specification().getStandards(resources)
        Arrays.stream(operational.specification).forEach(i ->this.inductionMap.put(i.getDatumClassName(),i));
    }

    public Operational getOperational() {
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
