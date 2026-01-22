/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item;

import dev.inward.matrix.Context;
import dev.inward.matrix.engine.Factory;
import dev.inward.matrix.concept.fact.Variant;
import dev.inward.matrix.control.authority.Authority;

public class ItemContext<ITEM,V extends ItemView<ITEM,V,M,C,X>,M extends ItemModel<ITEM,V,M,C,X>,C extends Clerk<ITEM,V,M,C,X>,X extends ItemContext<ITEM,V,M,C,X>> extends Context<ITEM,V,M,C,X> {

    public ItemContext(Variant variant, C clerk, Factory<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> factory, Authority[] agents) {
        super(variant, clerk, factory, agents);
    }
}
