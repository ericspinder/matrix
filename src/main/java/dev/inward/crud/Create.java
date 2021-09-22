package dev.inward.crud;

import dev.inward.HouseKeeping;
import dev.inward.fact.Fact;
import dev.inward.fact.session.Request;
import dev.inward.fact.session.Response;

import java.lang.reflect.Constructor;

public class Create<V extends Comparable<V>> extends CrudOperation<V> {

    protected Constructor<V> constructor;

    public Create() {

    }
    public V createNew(V value, HouseKeeping houseKeeping) {
        if (this.valueClass.isAssignableFrom(Fact.class)) {
            try {
                this.constructor.newInstance();

            } catch (ReflectiveOperationException roe) {
                return null;
            }
        }


    }

    public static class Default<V extends Comparable<V>> extends Create<V> {

        @Override
        protected Response beforeCreate(Request request) {
            return null;
        }

        @Override
        protected void afterCreate(Request request, Response response) {}


    }
}
