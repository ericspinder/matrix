/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatumModel<D extends Datum<D,R,A,RESOURCE,M>,R extends DatumReference<D,R,A,RESOURCE,M>,A extends DatumAttributes<D,R,A,RESOURCE,M>,RESOURCE extends DatumResource<D,R,A,RESOURCE,M>,M extends DatumModel<D,R,A,RESOURCE,M>> extends Model<D,R,A,RESOURCE,M> {
    public DatumModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }

    @Override
    public Map<String, InstanceValue> getInitialProperties(D item) {
        return new ConcurrentHashMap<>();
    }
}
