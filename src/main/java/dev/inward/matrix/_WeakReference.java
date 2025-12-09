/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.Concept;

import java.lang.ref.WeakReference;
import java.util.Map;

public class _WeakReference<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET>,C extends Concept<TARGET,V,M>> extends WeakReference<TARGET> implements Seat {

    protected final Long sequenceNumber;
    protected final Map<String, Model.InstanceValue<?>> attributes;

    public _WeakReference(TARGET referent, C concept) {
        super(referent, concept);
        sequenceNumber = concept.getSequenceNumber();
        this.attributes = concept.getModel().getInitialProperties(referent);
    }

    @Override
    public Map<String, Model.InstanceValue<?>> getAttributes() {
        return attributes;
    }

    @Override
    public Long getSequenceNumber() {
        return sequenceNumber;
    }
}
