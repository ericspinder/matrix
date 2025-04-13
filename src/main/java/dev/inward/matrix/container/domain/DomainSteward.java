/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.container.domain;

import dev.inward.matrix.container.ContainerSteward;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DomainSteward extends ContainerSteward<DomainKey,Domain,DomainView,DomainModel,DomainReference, DomainSteward> {
    public DomainSteward(Standard standard) {
        super(standard);
    }
}
