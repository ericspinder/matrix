/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DatumLibrarian<D extends Datum<D,V,M,R,B>,V extends DatumView<D,V,M,R,B>,M extends DatumModel<D,V,M,R,B>,R extends DatumReference<D,V,M,R,B>,B extends DatumLibrarian<D,V,M,R,B>> extends Librarian<D,V,M,R,B> {

    public DatumLibrarian(Standard standard) {
        super(standard);
    }
}
