/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item;

import dev.inward.matrix._WeakReference;

public abstract class ItemWeakReference<ITEM,V extends ItemView<ITEM,V,M,C>,M extends ItemModel<ITEM,V,M,C>,C extends Clerk<ITEM,V,M,C>> extends _WeakReference<ITEM, V, M, C> {

    public ItemWeakReference(ITEM referent, C clerk) {
        super(referent, clerk);
    }
}
