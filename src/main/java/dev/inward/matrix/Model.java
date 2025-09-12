/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.nio.file.attribute.FileAttribute;
import java.security.PermissionCollection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Model<TARGET> extends PermissionCollection {

    protected final Map<String,Aspect> labeledAspects = new ConcurrentHashMap<>();
    protected final Map<Aspect.AspectType<?>,Aspect> typedAspects = new ConcurrentHashMap<>();
    protected final List<Field> fields;

    @SuppressWarnings("unchecked")
    public Model(Class<? super TARGET> targetClass, Aspect[] labeledAspects) {
        for (Aspect aspect: labeledAspects) {
            this.labeledAspects.put(aspect.getLabel(),aspect);
            this.typedAspects.put(aspect.type, aspect);
        }
        if (targetClass == null) {
            targetClass = (Class<TARGET>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        this.fields = getAllModelFields(targetClass);
    }
    public static List<Field> getAllModelFields(Class<?> aClass) {
        List<Field> fields = new ArrayList<>();
        do {
            Collections.addAll(fields, aClass.getDeclaredFields());
            aClass = aClass.getSuperclass();
        } while (aClass != null);
        return fields;
    }

    public record InstanceValue<T>(Aspect aspect, Model.InstanceValue.Origin origin, T value) implements FileAttribute<T> {
        @Override
        public String name() {
            return aspect.label;
        }

        @Override
        public String toString() {
            return "InstanceValue[" +
                    "aspect=" + aspect + ", " +
                    "origin=" + origin + ", " +
                    "value=" + value + ']';
        }

        public enum Origin implements Meta_I {
                Datum_onLoad("datum_onLoad", "Value was loaded by its model as an initial properties"),
                Datum_onReload("datum_onReload", "Value was loaded by application after a change was detected"),
                Error_onLoad_illegalAccess("error_onLoad_illegalAccess", "Value is unavailable because of an access error on load"),
                Error_onLoad_unAssignable("error_onLoad_unAssignable", "Value is unavailable because it was unAssignable to the expected class"),
                Set_byView("set_byReference", "Value was changed by the View class");

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
    public Map<String,InstanceValue<?>> getInitialProperties(TARGET TARGET) {
        Map<String,InstanceValue<?>> map = new ConcurrentHashMap<>();
        for (Field field: fields) {
            Aspect aspect = labeledAspects.get(field.getName());
            if (aspect != null) {
                map.put(aspect.type.getLabel(),aspect.process(field, TARGET));
            }
        }
        return map;
    }

    public Map<String, Aspect> getLabeledAspects() {
        return labeledAspects;
    }
    public Map<Aspect.AspectType<?>,Aspect> getTypedAspects() {
        return typedAspects;
    }

}