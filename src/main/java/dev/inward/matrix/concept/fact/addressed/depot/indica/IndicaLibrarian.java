/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot.indica;

import dev.inward.matrix.concept.fact.addressed.depot.DepotLibrarian;
import dev.inward.matrix.concept.fact.addressed.depot.specification.Specification;
import dev.inward.matrix.concept.fact.addressed.depot.standard.Standard;
import dev.inward.matrix.predictable.Predictable;

public class IndicaLibrarian<P extends Predictable> extends DepotLibrarian<Indica<P>,IndicaKey<P>,IndicaView<P>,IndicaModel<P>, IndicaReference<P>, IndicaLibrarian<P>> {

    public IndicaLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
