/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DatumSteward<LB extends DatumLibrarian<LB,D,V,M,R,RESOURCE>,D extends Datum<LB,D,V,M,R,RESOURCE>,V extends DatumView<LB,D,V,M,R,RESOURCE>,M extends DatumModel<LB,D,V,M,R,RESOURCE>,R extends DatumReference<LB,D,V,M,R,RESOURCE>,RESOURCE extends DatumSteward<LB,D,V,M,R,RESOURCE>> extends Steward<D,V,M,R,RESOURCE> {

    public DatumSteward(Standard standard) {
        super(standard);
    }
}
