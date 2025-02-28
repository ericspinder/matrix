package dev.inward.matrix;

import java.util.function.Function;

class DatumResource<D extends Datum<D,E,A>, E extends Envoy<D,E,A>,A extends DatumAttributes<D,E,A>> extends Resource<D,E,A> {


    public DatumResource(Standard standard, Function<E,E> graveDigger) {
        super(standard, graveDigger);
    }
}
