/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.catalog.Catalog;
import dev.inward.matrix.item.datum.Datum;

import java.time.Instant;
import java.util.Arrays;

public class Engine<F extends File<F,K,V,M,R,L>,K extends FileKey<F,K,V,M,R,L>,V extends FileView<F,K,V,M,R,L>,M extends FileModel<F,K,V,M,R,L>,R extends FileReference<F,K,V,M,R,L>,L extends Librarian<F,K,V,M,R,L>> {

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
