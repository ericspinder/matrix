/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.indica;

import dev.inward.matrix.file.addressed.depot.DepotReference;

public class IndicaReference extends DepotReference<IndiciaKey,Indica, IndicaReference, IndicaAttributes,IndicaResource,IndicaModel> {
    public IndicaReference(Indica addressed, IndicaResource resource) {
        super(addressed, resource);
    }
}
