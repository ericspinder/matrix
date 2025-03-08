/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.source;

import dev.inward.matrix.file.addressed.depot.DepotResource;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class SourceResource extends DepotResource<SourceKey,Source,SourceReference,SourceAttributes,SourceResource,SourceModel> {
    public SourceResource(Function<SourceReference, SourceReference> graveDigger, SourceModel model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
