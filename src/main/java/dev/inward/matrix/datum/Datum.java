package dev.inward.matrix.datum;

import java.io.Serializable;


public abstract class Datum<DATUM,D extends Datum<DATUM,D>> implements Serializable {

//    @SuppressWarnings("unchecked")
//    public final Class<DATUM> DATUMClass = ((Class<DATUM>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
//    @SuppressWarnings("unchecked")
//    public final Class<D> datumClass = ((Class<D>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    @SuppressWarnings("unchecked")
    protected Tracking<DATUM,D> tracking = new Tracking(this);

}
