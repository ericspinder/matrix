package dev.inward.matrix.engine;

import dev.inward.matrix.Pathway;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.datum.Ware;
import dev.inward.matrix.Resource;

import java.time.Instant;
import java.util.*;

public class Engine<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>> {

    public final Instant createInstant = Instant.now();
    protected final Operational<PATH,P,ID,T,C> operational;
    protected List<M> modelList = new ArrayList<>();
    protected final Map<String,Induction<>> inductionMap = new HashMap<>();


    public Engine(O operational, S resources) {
        this.operational = operational;
        this.operational.specification().getStandards(resources)
        Arrays.stream(operational.specification).forEach(i ->this.inductionMap.put(i.getDatumClassName(),i));
    }

    public O getOperational() {
        return operational;
    }

    public <DATUM,D extends Datum<DATUM,D>> Ware<DATUM,D,?> buildEnvoy(DATUM datum) {
        Induction<> induction = (Induction<Y,DATUM,D,V,F,I,X,>) operational.specification().getStandards().get(datum.getClass());
        return induction.createEnvoy(datum,factory
        );
    }
    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,V>,V extends Ware<DATUM,D,V>> V add(DATUM datum) {
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
