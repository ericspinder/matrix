/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.directory.*;

public abstract class DatumReference<D extends Datum<D,V,M,R,L>,V extends DatumView<D,V,M,R,L>,M extends DatumModel<D,V,M,R,L>,R extends DatumReference<D,V,M,R,L>,L extends DatumLibrarian<D,V,M,R,L>> extends Reference<D,V,M,R,L> {


    public DatumReference(D datum, L librarian) {
        super(datum, librarian);
    }

    protected void doIncrementFailure(D datum, MatrixException matrixException) {
        datum.getClass().getProtectionDomain();

    }

}