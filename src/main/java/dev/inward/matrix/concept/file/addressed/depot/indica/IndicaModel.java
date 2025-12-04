/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.depot.indica;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.file.addressed.depot.DepotModel;

public class IndicaModel extends DepotModel<Indica,IndicaKey,IndicaView,IndicaModel, IndicaReference, IndicaLibrarian> {
    public IndicaModel(Aspect[] labeledAspects) {
        super(Indica.class, labeledAspects);
    }
}
