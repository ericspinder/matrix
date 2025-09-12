/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;

public abstract class ItemModel<ITEM,V extends ItemView<ITEM,V,M,C>,M extends ItemModel<ITEM,V,M,C>,C extends Clerk<ITEM,V,M,C>> extends Model<ITEM> {

    public ItemModel(Class<? super ITEM> datumClass, Aspect[] labeledAspects) {
        super(datumClass, labeledAspects);
    }
}