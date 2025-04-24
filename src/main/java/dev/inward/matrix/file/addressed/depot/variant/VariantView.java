/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.variant;

import dev.inward.matrix.file.addressed.depot.DepotView;

public class VariantView extends DepotView<VariantKey,Variant,VariantView,VariantModel,VariantReference,VariantLibrarian> {

    public VariantView(String name, Variant file, VariantReference fileReference) {
        super(name, file, fileReference);
    }
}
