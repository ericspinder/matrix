/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.administration;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.catalog.CatalogModel;
import dev.inward.matrix.control.ControlModel;

public abstract class AdministrationModel<AC extends Administration<AC,AV,AM>,AV extends AdministrationView<AC,AV,AM>,AM extends AdministrationModel<AC,AV,AM>> extends ControlModel<AC,AV,AM> {
    public AdministrationModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
