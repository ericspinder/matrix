/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public abstract class DatumReference<D extends Datum<D,V,M,R,B>,V extends DatumView<D,V,M,R,B>,M extends DatumModel<D,V,M,R,B>,R extends DatumReference<D,V,M,R,B>,B extends DatumLibrarian<D,V,M,R,B>> extends Reference<D,V,M,R,B> {


    public DatumReference(D datum, B librarian) {
        super(datum, librarian);
    }

    protected void doIncrementFailure(D datum, MatrixException matrixException) {
        datum.getClass().getProtectionDomain();

    }

}