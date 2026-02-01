/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item;

import dev.inward.matrix.Model;
import dev.inward.matrix.item.datum.standard.Standard;
import dev.inward.matrix.control.library.Library;

public abstract class ItemModel<ITEM,V extends ItemView<ITEM,V,M>,M extends ItemModel<ITEM,V,M>> extends Model<ITEM,V,M> {

    public ItemModel(Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library, Standard standard) {
        super(library, standard);
    }
}