/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.lang.reflect.Field;
import java.nio.file.attribute.FileTime;

public abstract class Aspect implements Meta_I, Comparable<Aspect> {

    protected final AspectType type;
    protected final String label;
    protected final String description;


    public Aspect(AspectType type, String label, String description) {
        this.type = type;
        this.label = label;
        this.description = description;
    }
    public interface AspectType extends Meta_I {
        Class<?> getExpectedClass();
    }
    public Model.InstanceValue process(final Field field, Object datum) {
        if (type.getExpectedClass().isAssignableFrom(field.getClass())) {
            try {
                return new Model.InstanceValue(this, Model.InstanceValue.Origin.Datum_onLoad, field.get(datum));
            }
            catch (IllegalAccessException e) {
                return new Model.InstanceValue(this, Model.InstanceValue.Origin.Error_onLoad_illegalAccess, null);
            }
        }
        return new Model.InstanceValue(this, Model.InstanceValue.Origin.Error_onLoad_unAssignable, null);
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

    public enum DefaultAspectType implements AspectType {
        LastModifiedTime("lastModifiedTime","The last time the datum was modified", FileTime.class),
        LastAccessTime("lastAccessTime", "The last time the datum was accessed", FileTime.class),
        CreateTime("createTime", "When the data was created", FileTime.class);
        private final String label;
        private final String description;
        private final Class<?> expectedClass;
        DefaultAspectType(String label, String description,Class<?> expectedClass) {
            this.label = label;
            this.description = description;
            this.expectedClass = expectedClass;
        }

        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public Class<?> getExpectedClass() {
            return expectedClass;
        }
    }
}

