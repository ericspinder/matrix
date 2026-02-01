/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum;

import dev.inward.matrix.item.datum.standard.Standard;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.item.Clerk;

public class DatumClerk<D extends Datum<D,V,M>,V extends DatumView<D,V,M>,M extends DatumModel<D,V,M>,C extends DatumClerk<D,V,M,C,X>,X extends DatumContext<D,V,M,C,X>> extends Clerk<D,V,M,C,X> {

    public DatumClerk(Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library, Standard standard) {
        super(library, standard);
    }
}
