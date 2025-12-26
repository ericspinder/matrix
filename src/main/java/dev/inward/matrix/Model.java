/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.Concept;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.attribute.FileAttribute;
import java.security.PermissionCollection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public abstract class Model<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>> extends ReferenceQueue<TARGET> {

    protected final Map<String,Aspect> labeledAspects = new ConcurrentHashMap<>();
    protected final Map<Aspect.AspectType<?>,Aspect> typedAspects = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();
    protected final AtomicLong removed = new AtomicLong();
    protected long warnOnTotal;
    protected long hardLimit;

    @SuppressWarnings("unchecked")
    public Model(Aspect[] labeledAspects) {
        for (Aspect aspect : labeledAspects) {
            this.labeledAspects.put(aspect.getLabel(), aspect);
            this.typedAspects.put(aspect.type, aspect);
        }
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
            Version_Upgrade_default("version_upgrade_default", "Value was a loaded default as part of a version upgrade"),
            Version_Upgrade_calculated("version_upgrade_calculated", "Value was calculated and as part of a version upgrade"),
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

    protected Function<Reference<? extends TARGET>, Reference<? extends TARGET>> createGraveDiggerInstance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (Function<Reference<? extends TARGET>, Reference<? extends TARGET>>) Class.forName(standard.getGraveDiggerClassName()).getDeclaredConstructor(Concept.class).newInstance(this);
    }

    private Map<String,InstanceValue<?>> getInitialProperties(TARGET TARGET) {
        Class<?> currentClass = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        List<Field> worker = new ArrayList<>();
        do {
            Collections.addAll(worker, currentClass.getDeclaredFields());
            currentClass = currentClass.getSuperclass();
        } while (currentClass != null);
        Map<String,InstanceValue<?>> map = new ConcurrentHashMap<>();
        for (Field field: worker) {
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