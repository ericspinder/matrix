/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.depot.specification;

import dev.inward.matrix.concept.file.addressed.depot.DepotReference;

public class SpecificationReference extends DepotReference<Specification,SpecificationKey,SpecificationView,SpecificationModel, SpecificationReference, SpecificationLibrarian> {
    public SpecificationReference(Specification addressed, SpecificationLibrarian resource) {
        super(addressed, resource);
    }
}
