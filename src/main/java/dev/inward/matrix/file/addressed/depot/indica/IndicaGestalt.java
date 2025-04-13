/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.indica;

import dev.inward.matrix.file.addressed.depot.DepotGestalt;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class IndicaGestalt extends DepotGestalt<IndicaKey,Indica, IndicaReference, IndicaView, IndicaGestalt,IndicaModel> {
    public IndicaGestalt(Function<IndicaReference, IndicaReference> graveDigger, IndicaModel model, Class<IndicaView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
