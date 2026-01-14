/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.ControlModel;

public abstract class CatalogModel<CC extends Catalog<CC,CV,CM>,CV extends CatalogView<CC,CV,CM>,CM extends CatalogModel<CC,CV,CM>> extends ControlModel<CC,CV,CM> {

    protected final Class<CC> memoryClass;

    public CatalogModel(Class<CC> memoryClass, Aspect[] labeledAspects) {
        super(labeledAspects);
        this.memoryClass = memoryClass;
    }

    public final Class<CC> getMemoryClass() {
        return memoryClass;
    }
}
