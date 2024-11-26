package dev.inward;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public abstract class Datum<DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>> implements Serializable {

    @SuppressWarnings("unchecked")
    public final Envoy<DATUM,D,V> envoy = ((Factory<?,?,?,?,?,?>)this.getClass().getClassLoader()).add((D)this);

}
