package dev.inward.crud;

import dev.inward.log.Request;
import dev.inward.log.Response;
import dev.inward.morph.Morph;

import java.lang.reflect.ParameterizedType;

public abstract class Crudem<V extends Comparable<V>, M extends Morph<?>, Q extends Request<?,?>, R extends Response<?,?>> {

    public final Class<V> valueClass;

    public abstract R fulfill(M morph, Q request);

    public enum Operation {
        Create,
        Read,
        Update,
        Delete,
        Execute,
        Moderate;
    }

    public Crudem() {
        this.valueClass = (Class<V>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
