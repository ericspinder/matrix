/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.specification;

import dev.inward.matrix.file.addressed.depot.DepotLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.util.function.Function;

public class SpecificationLibrarian extends DepotLibrarian<Specification,SpecificationKey,SpecificationView,SpecificationModel,SpecificationReference,SpecificationLibrarian> {

    public SpecificationLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
