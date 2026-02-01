/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item;

import dev.inward.matrix.View;

public abstract class ItemView<ITEM,V extends ItemView<ITEM,V,M>,M extends ItemModel<ITEM,V,M>> extends View<ITEM,V,M> {

    public ItemView(String name, ITEM item) {
        super(name, item);
    }

}
