package com.notionds.dataSupplier.aggregation.reflection;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.BooleanOption;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public class Proxy<N, O extends Operational<N,W,T>, W extends Datum<N,O,T>, T extends Container<N,O,W>> implements InvocationHandler, Datum<N,O,T> {

    private UUID artifactId = UUID.randomUUID();
    protected final N delegate;
    protected final T container;
    protected final boolean equalsByUUID;

    public Proxy(N delegate, Operational<N,W,T> operational, T container) {
        this.delegate = delegate;
        this.container = container;
        this.equalsByUUID = operational.getBoolean(BooleanOption.EqualsByUUID.getI18n());

    }
    @Override
    public UUID getDatumUuid() {
        return this.artifactId;
    }
    @Override
    public T getContainer() {
        return this.container;
    }

    @Override
    public N getDelegate() {
        return this.delegate;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        switch (m.getName()) {
            case "close":
            case "free":
                this.container.closeDelegate();
                return Void.TYPE;
            case "isWrapperFor":
                return ((Class<?>) args[0]).isInstance(delegate);
            case "unwrap":
                if (((Class<?>) args[0]).isInstance(delegate)) {
                    return delegate;
                }
                return null;
            case "getContainer":
                return getContainer();
            case "getArtifactId":
                return getDatumUuid();
            case "equals":
                if (equalsByUUID) return this.artifactId.equals(args[0]);
                return equals(args[0]);
        }
        if (m.getReturnType().equals(Void.TYPE)) {
            try {
                m.invoke(delegate, args);
            } catch (InvocationTargetException ite) {
                container.handleException(ite, this);
                throw ite;
            }
            return Void.TYPE;
        }
        if (m.getReturnType().isPrimitive()) {
            try {
                return m.invoke(delegate, args);
            } catch (InvocationTargetException ite) {
                container.handleException(ite, this);
                throw ite;
            }
        }
        try {
            Object object = m.invoke(delegate, args);
            //String maybeSql = (args != null && args[0] instanceof String) ? (String) args[0] : null;
            Datum connectionMember = container.getBus().getFactory().wrap(object, m.getReturnType(), args);
            if (connectionMember != null) {
                return connectionMember;
            }
            return object;
        } catch (InvocationTargetException ite) {
            container.handleException(ite, this);
            throw ite;
        }
    }

    @Override
    public final boolean equals(final Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (!(that instanceof Datum)) {
            return false;
        }
        if (this.getDatumUuid() == null) {
            if (((Datum)that).getDatumUuid() != null) {
                return false;
            }
        } else if (!this.getDatumUuid().equals(((Datum)that).getDatumUuid())) {
            return false;
        }
        return true;
    }
}
