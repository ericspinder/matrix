/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.specification;

import dev.inward.matrix.file.addressed.depot.DepotView;

public class SpecificationView extends DepotView<SpecificationLibrarian,SpecificationKey,Specification,SpecificationView,SpecificationModel,SpecificationReference, SpecificationSteward> {
    public SpecificationView(Specification specification, SpecificationModel specificationModel) {
        super("SpecificationView", specification, specificationModel);
    }
}
