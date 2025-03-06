/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.indica;

import dev.inward.matrix.file.addressed.depot.DepotResource;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class IndicaResource extends DepotResource<IndiciaKey,Indica, IndicaReference, IndicaAttributes,IndicaResource,IndicaModel> {
    public IndicaResource(Function<IndicaReference, IndicaReference> graveDigger, IndicaModel model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
