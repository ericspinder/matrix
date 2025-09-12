/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.bureau;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.catalog.CatalogModel;

public abstract class BureauModel<BC extends Bureau<BC,BV,BM>,BV extends BureauView<BC,BV,BM>,BM extends BureauModel<BC,BV,BM>> extends CatalogModel<BC,BV,BM> {
    public BureauModel(Class<BC> bureauClass, Aspect[] labeledAspects) {
        super(bureauClass, labeledAspects);
    }
}
