/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum;

import dev.inward.matrix.concept.fact.addressed.depot.standard.Standard;
import dev.inward.matrix.item.Clerk;

public class DatumClerk<D extends Datum<D,V,M,C>,V extends DatumView<D,V,M,C>,M extends DatumModel<D,V,M,C>,C extends DatumClerk<D,V,M,C>> extends Clerk<D,V,M,C> {

    public DatumClerk(Standard standard) {
        super(standard);
    }
}
