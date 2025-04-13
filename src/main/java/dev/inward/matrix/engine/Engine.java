/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.engine;

import dev.inward.matrix.Datum;
import dev.inward.matrix.DatumReference;
import dev.inward.matrix.Steward;
import dev.inward.matrix.Operational;
import dev.inward.matrix.addressed.*;
import dev.inward.matrix.file.addressed.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Engine<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends AddressedReference<PATH,ID,I,A,R,F>,F extends AddressedView<PATH,ID,I,A,R,F>> {

    public final Instant createInstant = Instant.now();
    protected final Operational<PATH,ID,I,A,R,F> operational;
    protected final Map<String,Induction<>> inductionMap = new HashMap<>();


    public Engine(Operational<PATH,ID,I,A,R,F> operational, AddressedSteward<PATH,ID,I,A,R,F> resources) {
        this.operational = operational;
        resources.specification().getStandards(resources)
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
            Steward<DATUM> steward = (Steward<DATUM>) this.producer.get(((D) datum).getClass());
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
