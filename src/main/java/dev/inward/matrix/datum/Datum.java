package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public abstract class Datum<DATUM,D extends Datum<DATUM,D, V,F,I,X,P>,V extends Envoy<DATUM,D, V,?,?,?,?>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>> implements Serializable {

    @SuppressWarnings("unchecked")
    public final Class<DATUM> DATUMClass = ((Class<DATUM>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    @SuppressWarnings("unchecked")
    public final Class<D> datumClass = ((Class<D>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    @SuppressWarnings("unchecked")
    public final Class<V> envoyClass = ((Class<V>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);

    protected Tracking<DATUM,D, V> tracking = new Tracking(this);

}
