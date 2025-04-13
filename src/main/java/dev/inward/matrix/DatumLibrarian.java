/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public class DatumLibrarian<LB extends DatumLibrarian<LB,D,V,M,R, G>,D extends Datum<LB,D,V,M,R, G>,V extends DatumView<LB,D,V,M,R,G>,M extends DatumModel<LB,D,V,M,R, G>,R extends DatumReference<LB,D,V,M,R, G>, G extends DatumSteward<LB,D,V,M,R, G>> extends Librarian<D,V,M,R, G> {
    protected DatumLibrarian(G gestalt) {
        super(gestalt);
    }
}
