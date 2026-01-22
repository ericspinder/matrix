/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix.item.datum;

public interface Datum<D extends Datum<D,V,M,C,X>,V extends DatumView<D,V,M,C,X>,M extends DatumModel<D,V,M,C,X>,C extends DatumClerk<D,V,M,C,X>,X extends DatumContext<D,V,M,C,X>> {

    Seat<D,V,M,C> seat();


}
