/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.Control;

import java.lang.reflect.Field;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Map;

public abstract class Aspect implements Meta_I, Comparable<Aspect> {

    protected final AspectType<?> type;

    protected final String label;
    protected final String description;


    public Aspect(AspectType<?> type, String label, String description) {
        this.type = type;
        this.label = label;
        this.description = description;
    }
    public abstract static class AspectType<T> implements Meta_I {

        protected final String label;
        protected final String description;
        protected final Class<T> expectedClass;
        protected final boolean allowNull;

        public AspectType(String label, String description, Class<T> expectedClass, boolean allowNull) {
            this.label = label;
            this.description = description;
            this.expectedClass = expectedClass;
            this.allowNull = allowNull;
        }

        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getDescription() {
            return description;
        }

        public Class<?> getExpectedClass() {
            return expectedClass;
        }
        public static class PathAspectType<T> extends AspectType<T> {

            protected final int position;
            public PathAspectType(String label, String description, Class<T> expectedClass, boolean allowNull, int position) {
                super(label, description, expectedClass, allowNull);
                this.position = position;
            }

            public int getPosition() {
                return position;
            }
        }
        public static class MappedAspectType<K,V> extends AspectType<Map<K,V>> {

            public MappedAspectType(String label, String description, Class<Map<K, V>> expectedClass, boolean allowNull) {
                super(label, description, expectedClass, allowNull);
            }
        }
        public static class ListedAspectType<T> extends AspectType<List<T>> {

            public ListedAspectType(String label, String description, Class<List<T>> expectedClass, boolean allowNull) {
                super(label, description, expectedClass, allowNull);
            }
        }

        public static class ObjectAspectType<T> extends AspectType<T> {

            public static final ObjectAspectType<FileTime> Last_Modified_Time = new ObjectAspectType<>("lastModifiedTime","The last time the datum was modified", FileTime.class, true);

            public static final ObjectAspectType<FileTime> Last_Accessed_Time = new ObjectAspectType<>("lastAccessTime", "The last time the datum was accessed", FileTime.class, true);
            public static final ObjectAspectType<FileTime> Create_Time = new ObjectAspectType<>("createTime", "When the data was created", FileTime.class, true);
            public ObjectAspectType(String label, String description, Class<T> expectedClass, boolean allowNull) {
                super(label, description, expectedClass, allowNull);
            }
        }
        public static class QueryAspectType<T> extends AspectType<T> {

            public QueryAspectType(String label, String description, Class<T> expectedClass, boolean allowNull) {
                super(label, description, expectedClass, allowNull);
            }
        }
        public static class AnchorAspectType<T> extends AspectType<T> {

            public AnchorAspectType(String label, String description, Class<T> expectedClass, boolean allowNull) {
                super(label, description, expectedClass,allowNull);
            }
        }
    }
    public Model.InstanceValue<?> process(final Field field, Object datum) {
        if (type.getExpectedClass().isAssignableFrom(field.getClass())) {
            try {
                return new Model.InstanceValue<>(this, Model.InstanceValue.Origin.Datum_onLoad, field.get(datum));
            }
            catch (IllegalAccessException e) {
                return new Model.InstanceValue<>(this, Model.InstanceValue.Origin.Error_onLoad_illegalAccess, null);
            }
        }
        return new Model.InstanceValue<>(this, Model.InstanceValue.Origin.Error_onLoad_unAssignable, null);
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int compareTo(Aspect that) {
        return this.label.compareTo(that.label);
    }

}

