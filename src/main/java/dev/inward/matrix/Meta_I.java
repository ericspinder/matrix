/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public interface Meta_I {

    String getLabel();
    String getDescription();

    default String getClassName() {
        return (this.getClass().isAssignableFrom(Enum.class) && ((Enum<?>) this).describeConstable().isPresent())  ? ((Enum<?>) this).describeConstable().get().getClass().getCanonicalName() : this.getClass().getCanonicalName();
    }

    default String getI18n() {
        return this.parseDefaultI18n();
    }
    default String parseDefaultI18n() {
        if (this.getLabel() == null) {
            return getClassName();
        }
        return getLabel();
    }

}
