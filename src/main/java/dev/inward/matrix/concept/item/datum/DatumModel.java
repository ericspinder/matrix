/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.item.datum;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.item.ItemModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatumModel<D extends Datum<D,V,M,C>,V extends DatumView<D,V,M,C>,M extends DatumModel<D,V,M,C>,C extends DatumClerk<D,V,M,C>> extends ItemModel<D,V,M,C> {
    public DatumModel(Class<D> datumClass, Aspect[] labeledAspects) {
        super(datumClass, labeledAspects);
    }

    @Override
    public Map<String, InstanceValue<?>> getInitialProperties(D item) {
        return new ConcurrentHashMap<>();
    }
}
