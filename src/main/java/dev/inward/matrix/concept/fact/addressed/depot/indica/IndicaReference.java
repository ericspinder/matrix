/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot.indica;

import dev.inward.matrix.concept.fact.addressed.depot.DepotReference;
import dev.inward.matrix.predictable.Executable;

public class IndicaReference<P extends Executable> extends DepotReference<Indica<P>,IndicaKey<P>,IndicaView<P>,IndicaModel<P>, IndicaReference<P>, IndicaLibrarian<P>> {
    public IndicaReference(Indica<P> addressed, IndicaLibrarian<P> resource) {
        super(addressed, resource);
    }
}
