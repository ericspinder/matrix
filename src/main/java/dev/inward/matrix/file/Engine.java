/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.file.directory.*;

import java.time.Instant;
import java.util.Arrays;

public class Engine<PATH extends Comparable<PATH>,DK extends DirectoryKey<PATH,DK,DF,DV,DM,DR,DB>,DF extends Directory<PATH,DK,DF,DV,DM,DR,DB>,DV extends DirectoryView<PATH,DK,DF,DV,DM,DR,DB>,DM extends DirectoryModel<PATH,DK,DF,DV,DM,DR,DB>,DR extends DirectoryReference<PATH,DK,DF,DV,DM,DR,DB>,DB extends DirectoryLibrarian<PATH,DK,DF,DV,DM,DR,DB>,K extends FileKey<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,F extends File<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,V extends FileView<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,M extends FileModel<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,R extends FileReference<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,B extends FileLibrarian<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>> {

    public final Instant createInstant = Instant.now();
    protected final Operational<DATUM,V,M,R,B> operational;

    public Engine(Operational<DATUM,V,M,R,B> operational, B resource) {
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
