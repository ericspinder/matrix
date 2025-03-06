/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class HouseResource extends PrivilegeResource<HouseKey,House,HouseReference,HouseAttributes,HouseResource,HouseModel> {
    public HouseResource(Function<HouseReference, HouseReference> graveDigger, HouseModel model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
