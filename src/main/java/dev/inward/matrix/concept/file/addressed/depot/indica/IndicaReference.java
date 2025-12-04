/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.depot.indica;

import dev.inward.matrix.concept.file.addressed.depot.DepotReference;

public class IndicaReference extends DepotReference<Indica,IndicaKey,IndicaView,IndicaModel, IndicaReference, IndicaLibrarian> {
    public IndicaReference(Indica addressed, IndicaLibrarian resource) {
        super(addressed, resource);
    }
}
