/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.item.datum;

import dev.inward.matrix.concept.item.ItemView;

public class DatumView<D extends Datum<D,V,M,C>,V extends DatumView<D,V,M,C>,M extends DatumModel<D,V,M,C>,C extends DatumClerk<D,V,M,C>> extends ItemView<D,V,M,C> {

    protected final M model;

    public DatumView(String name, D datum,C clerk) {
        super(name, datum);
        this.model = clerk.getModel();
    }

    @Override
    public M getModel() {
        return this.model;
    }
}
