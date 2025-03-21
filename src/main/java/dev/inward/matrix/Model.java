/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.attribute.AttributeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Model<DATUM,R extends Reference<DATUM,R,A,RESOURCE,M>,A extends Attributes<DATUM,R,A,RESOURCE,M>,RESOURCE extends Resource<DATUM,R,A,RESOURCE,M>,M extends Model<DATUM,R,A,RESOURCE,M>> {

    protected long warnOnTotal;
    protected long hardLimit;
    protected final Map<String,Aspect> labeledAspects = new ConcurrentHashMap<>();
    protected final Map<Aspect.AspectType,Aspect> typedAspects = new ConcurrentHashMap<>();
    protected final List<Field> fields;

    @SuppressWarnings("unchecked")
    public Model(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        for (Aspect aspect: labeledAspects) {
            this.labeledAspects.put(aspect.getLabel(),aspect);
            this.typedAspects.put(aspect.type, aspect);
        }
        this.fields = getAllModelFields(((Class<DATUM>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]));
        this.warnOnTotal = warnOnTotal;
        this.hardLimit = hardLimit;
    }
    public static List<Field> getAllModelFields(Class<?> aClass) {
        List<Field> fields = new ArrayList<>();
        do {
            Collections.addAll(fields, aClass.getDeclaredFields());
            aClass = aClass.getSuperclass();
        } while (aClass != null);
        return fields;
    }

    @SuppressWarnings("unchecked")
    public R wrap(DATUM item, RESOURCE resource) {
        try {
            return ((Class<R>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]).getDeclaredConstructor(Object.class, Resource.class).newInstance(item, resource);
        } catch (ClassCastException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public record InstanceValue(Aspect aspect, Model.InstanceValue.Origin origin, Object value) {
            public enum Origin implements Meta_I {
                Datum_onLoad("datum_onLoad", "Value was loaded with initial properties"),
                Datum_onReload("datum_onReload", "Value was loaded by application after a change was detected"),
                Error_onLoad_illegalAccess("error_onLoad_illegalAccess", "Value is unavailable because of an access error on load"),
                Error_onLoad_unAssignable("error_onLoad_unAssignable", "Value is unavailable because it was unAssignable to the expected class"),
                Set_byReference("set_byReference", "Value was loaded by the Reference class");

                private final String label;
                private final String description;

                Origin(String label, String description) {
                    this.label = label;
                    this.description = description;
                }

                @Override
                public String getLabel() {
                    return label;
                }

                @Override
                public String getDescription() {
                    return description;
                }
            }
    }
    public Map<String,InstanceValue> getInitialProperties(DATUM item) {
        Map<String,InstanceValue> map = new ConcurrentHashMap<>();
        for (Field field: fields) {
            Aspect aspect = labeledAspects.get(field.getName());
            if (aspect != null) {
                map.put(aspect.type.getLabel(),aspect.process(field,item));
            }
        }
        return map;
    }


    public Map<String, Aspect> getLabeledAspects() {
        return labeledAspects;
    }
    public Map<Aspect.AspectType,Aspect> getTypedAspects() {
        return typedAspects;
    }
    public long getWarnOnTotal() {
        return this.warnOnTotal;
    }

    public long getHardLimit() {
        return hardLimit;
    }

    public void setWarnOnTotal(long warnOnTotal) {
        this.warnOnTotal = warnOnTotal;
    }

    public void setHardLimit(long hardLimit) {
        this.hardLimit = hardLimit;
    }
}