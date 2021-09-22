package dev.inward.crud;

import java.lang.reflect.ParameterizedType;

public class CrudOperation<V extends Comparable<V>> {

    protected Class<V> valueClass;

    public CrudOperation() {
        this.valueClass = (Class<V>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
