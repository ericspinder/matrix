package dev.inward.matrix;

import dev.inward.matrix.*;
import dev.inward.matrix.Aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Model<DATUM,W extends Ware<DATUM,W,A>,A extends Attributes<DATUM,W,A>> {

    protected final Map<String,Aspect> labeledAspects = new ConcurrentHashMap<>();

    public Model(Aspect[] labeledAspects) {
        for (Aspect aspect: labeledAspects) {
            this.labeledAspects.put(aspect.getLabel(),aspect);
        }
    }
    public DATUM newDatum(Object... objects) {
        throw new UnsupportedOperationException();
    }
    @SuppressWarnings("unchecked")
    public W wrap(Resource<DATUM,W,A> resource, DATUM datum) {
        try {
            return ((Class<W>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]).getDeclaredConstructor(Resource.class,Object.class).newInstance(resource, datum);
        } catch (ClassCastException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract Properties getIntitalProperties(DATUM datum);
    public abstract void delete(W datum);

    public Map<String, Aspect> getLabeledAspects() {
        return labeledAspects;
    }
}