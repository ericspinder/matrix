package dev.inward.matrix.engine;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.route.Route;

import java.time.Instant;
import java.util.*;

public class Engine<S extends Scheme<S,L,PATH,N>,L extends Library<S,L,PATH,N>,PATH extends Comparable<PATH>,F extends Fact<S,L,PATH,F,N>,M extends Model<S,L,PATH,F,M,N>,N extends Notion<S,L,PATH,N>,O extends Operational<S,L,PATH,F,O>,R extends Resources<S,L,PATH,F>> {

    public final Instant createInstant = Instant.now();
    protected final O operational;
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
