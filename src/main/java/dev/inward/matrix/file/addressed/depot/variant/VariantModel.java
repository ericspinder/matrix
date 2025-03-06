/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.variant;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.depot.DepotModel;

public class VariantModel extends DepotModel<VariantKey,Variant,VariantReference,VariantAttributes,VariantResource, VariantModel> {
    public VariantModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }
}
