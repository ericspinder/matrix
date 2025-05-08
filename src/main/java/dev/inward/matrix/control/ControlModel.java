/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;
import dev.inward.matrix.control.catalog.Catalog;

public abstract class ControlModel<C extends Control<C,V,M>,V extends ControlView<C,V,M>,M extends ControlModel<C,V,M>> extends Model<C> {
    public ControlModel(Class<? super C> controlClass, Aspect[] labeledAspects) {
        super(controlClass, labeledAspects);
    }
}
