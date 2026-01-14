/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.item;

import dev.inward.matrix.View;

public abstract class ItemView<ITEM,V extends ItemView<ITEM,V,M,C,X>,M extends ItemModel<ITEM,V,M,C,X>,C extends Clerk<ITEM,V,M,C,X>,X extends ItemContext<ITEM,V,M,C,X>> extends View<ITEM,V,M> {

    public ItemView(String name, ITEM item) {
        super(name, item);
    }

}
