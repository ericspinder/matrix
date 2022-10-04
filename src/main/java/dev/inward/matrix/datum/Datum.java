package dev.inward.matrix.datum;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public abstract class Datum<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> implements Serializable {

    @SuppressWarnings("unchecked")
    public final Class<DATUM> DATUMClass = ((Class<DATUM>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    @SuppressWarnings("unchecked")
    public final Class<D> datumClass = ((Class<D>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    @SuppressWarnings("unchecked")
    public final Class<V> envoyClass = ((Class<V>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);

    protected Tracking<DATUM,D,V> tracking = new Tracking(this);

}
