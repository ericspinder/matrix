/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.variant;

import dev.inward.matrix.file.addressed.depot.DepotSteward;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class VariantSteward extends DepotSteward<VariantLibrarian,VariantKey,Variant,VariantView,VariantModel,VariantReference, VariantSteward> {
    public VariantSteward(Function<VariantReference, VariantReference> graveDigger, Class<VariantView> variantViewClass, VariantModel model, Specification specification) {
        super(graveDigger, model, variantViewClass, specification);
    }
}
