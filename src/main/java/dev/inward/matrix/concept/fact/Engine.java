/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.fact;

import dev.inward.matrix.Seat;
import dev.inward.matrix.concept.catalog.Catalog;
import dev.inward.matrix.concept.Concept;
import dev.inward.matrix.concept.item.datum.Datum;

import java.time.Instant;
import java.util.Arrays;

public class Engine<F extends Fact<F,K,V,M,R,L>,K extends FactKey<F,K,V,M,R,L>,V extends FactView<F,K,V,M,R,L>,M extends FactModel<F,K,V,M,R,L>,R extends Seat,L extends Librarian<F,K,V,M,R,L>> {

    public final Instant createInstant = Instant.now();
    protected final Operational<DATUM,V,M,R,B> operational;

    public Engine(Catalog<?,?,?> catalog) {
        this.operational = operational;
        Arrays.stream(operational.specification).forEach(i ->this.inductionMap.put(i.getDatumClassName(),i));
    }

    public Operational getOperational() {
        return operational;
    }

    public R buildReference(DATUM datum) {
        Induction<> induction = (Induction<Y,DATUM,D,V,F,I,X,>) operational.specification().getStandards().get(datum.getClass());
        return induction.createEnvoy(datum,factory
        );
    }
    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,V>,V extends DatumReferenceWeak<DATUM,D,V>> V add(DATUM datum) {
        try {
            Concept<DATUM> steward = (Concept<DATUM>) this.producer.get(((D) datum).getClass());
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
