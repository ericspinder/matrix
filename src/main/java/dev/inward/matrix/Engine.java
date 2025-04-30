/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;

public class Engine<DATUM,V extends View<DATUM,V,M,R,B>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,B>,B extends Librarian<DATUM,V,M,R,B>> {

    public final Instant createInstant = Instant.now();
    protected final Operational<PATH,ID,I,A,R,F> operational;
    protected final Map<String, Induction<>> inductionMap = new HashMap<>();


    public Engine(Operational<PATH,ID,I,A,R,F> operational, B resource) {
        this.operational = operational;
        resource.specification().getStandards(resource);
        this.getClass().getProtectionDomain()
        Arrays.stream(operational.specification).forEach(i ->this.inductionMap.put(i.getDatumClassName(),i));
    }

    public Operational getOperational() {
        return operational;
    }

    public <DATUM,D extends Datum<DATUM,D>> DatumReference<DATUM,D,?> buildEnvoy(DATUM datum) {
        Induction<> induction = (Induction<Y,DATUM,D,V,F,I,X,>) operational.specification().getStandards().get(datum.getClass());
        return induction.createEnvoy(datum,factory
        );
    }
    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,V>,V extends DatumReference<DATUM,D,V>> V add(DATUM datum) {
        try {
            Librarian<DATUM> steward = (Librarian<DATUM>) this.producer.get(((D) datum).getClass());
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
