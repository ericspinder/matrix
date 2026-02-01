/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum;

import dev.inward.matrix.concept.fact.Variant;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.engine.Factory;

public interface DatumContext<D extends Datum<D,V,M>,V extends DatumView<D,V,M>,M extends DatumModel<D,V,M>,C extends DatumClerk<D,V,M,C,X>,X extends DatumContext<D,V,M,C,X>> extends dev.inward.matrix.Context<D,V,M,C,X> {

    public DatumContext(Variant variant, C clerk, Factory<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> factory, Authority[] agents) {
        super(variant, clerk, factory, agents);
    }
}
