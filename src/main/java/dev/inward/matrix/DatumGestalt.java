/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.util.function.Function;

public class DatumGestalt<LB extends DatumLibrarian<LB,D,V,M,R,RESOURCE>,D extends Datum<LB,D,V,M,R,RESOURCE>,V extends DatumView<LB,D,V,M,R,RESOURCE>,M extends DatumModel<LB,D,V,M,R,RESOURCE>,R extends DatumReference<LB,D,V,M,R,RESOURCE>,RESOURCE extends DatumGestalt<LB,D,V,M,R,RESOURCE>> extends Gestalt<D,V,M,R,RESOURCE> {

    public DatumGestalt(Function<R, R> graveDigger, M model) {
        super(graveDigger, model);
    }
}
