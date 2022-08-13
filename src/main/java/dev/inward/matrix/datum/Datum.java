package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public abstract class Datum<DATUM,D extends Datum<DATUM,D,V,IC,XC>,V extends Envoy<DATUM,D,V,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> implements Serializable {

    @SuppressWarnings("unchecked")
    public final Class<DATUM> DATUMClass = ((Class<DATUM>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    @SuppressWarnings("unchecked")
    public final Class<D> datumClass = ((Class<D>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    @SuppressWarnings("unchecked")
    public final Class<V> envoyClass = ((Class<V>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);

    protected Tracking<DATUM,D,V,IC,XC> tracking = new Tracking(this);

}
