/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot.indica;

import dev.inward.matrix.concept.fact.addressed.depot.DepotLibrarian;
import dev.inward.matrix.concept.fact.addressed.depot.specification.Specification;
import dev.inward.matrix.concept.fact.addressed.depot.standard.Standard;

public class IndicaLibrarian extends DepotLibrarian<Indica,IndicaKey,IndicaView,IndicaModel, IndicaReference, IndicaLibrarian> {

    public IndicaLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
