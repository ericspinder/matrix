/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.platform;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.catalog.CatalogModel;

public abstract class PlatformModel<BC extends Platform<BC,BV,BM>,BV extends PlatformView<BC,BV,BM>,BM extends PlatformModel<BC,BV,BM>> extends CatalogModel<BC,BV,BM> {
    public PlatformModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
