/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.variant;

import dev.inward.matrix.file.addressed.depot.DepotReference;

public class VariantReference extends DepotReference<VariantLibrarian,VariantKey,Variant,VariantView,VariantModel,VariantReference, VariantSteward> {
    public VariantReference(Variant addressed, VariantSteward variantResource) {
        super(addressed, variantResource);
    }
}
