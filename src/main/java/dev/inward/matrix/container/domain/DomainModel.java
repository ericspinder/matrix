/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.container.domain;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.container.ContainerModel;

public class DomainModel extends ContainerModel<DomainKey,Domain,DomainView,DomainModel,DomainReference, DomainSteward> {
    public DomainModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
