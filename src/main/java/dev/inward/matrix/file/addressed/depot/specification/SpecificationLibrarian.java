/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.specification;

import dev.inward.matrix.file.addressed.depot.DepotLibrarian;

import java.util.function.Function;

public class SpecificationLibrarian extends DepotLibrarian<SpecificationLibrarian,SpecificationKey,Specification,SpecificationView,SpecificationModel,SpecificationReference, SpecificationLibrarian> {
    public SpecificationLibrarian(Function<SpecificationReference, SpecificationReference> graveDigger, SpecificationModel model, Class<SpecificationView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
