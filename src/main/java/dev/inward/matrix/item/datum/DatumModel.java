/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.item.ItemModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatumModel<D extends Datum<D,V,M>,V extends DatumView<D,V,M>,M extends DatumModel<D,V,M>> extends ItemModel<D,V,M,C> {
    public DatumModel(Class<D> datumClass, Aspect[] labeledAspects) {
        super(datumClass, labeledAspects);
    }

    @Override
    public Map<String, InstanceValue<?>> getInitialProperties(D item) {
        return new ConcurrentHashMap<>();
    }
}
