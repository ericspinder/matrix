/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.item;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;

public abstract class ItemModel<ITEM,V extends ItemView<ITEM,V,M,C,X>,M extends ItemModel<ITEM,V,M,C,X>,C extends Clerk<ITEM,V,M,C,X>,X extends ItemContext<ITEM,V,M,C,X>> extends Model<ITEM,V,M> {

    public ItemModel(Class<? super ITEM> datumClass, Aspect[] labeledAspects) {
        super(datumClass, labeledAspects);
    }
}