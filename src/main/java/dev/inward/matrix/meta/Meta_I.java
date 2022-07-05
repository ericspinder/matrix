package dev.inward.matrix.meta;

import java.lang.reflect.ParameterizedType;

public interface Meta_I<OPTION,M extends Meta_I<OPTION,M>> extends Comparable<M> {

    String getLabel();
    default String getI18n() {
        if (this.getDatumClass().isAssignableFrom(Enum.class)) {
            return ((Enum)this).describeConstable().get().getClass().getCanonicalName();
        }
        else {
            return this.getDatumClass().getCanonicalName();
        }
    }
    String getDescription();
    default Class<OPTION> getDatumClass() {
        return ((Class<OPTION>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    default int compareTo(M that) {
        return this.getLabel().compareTo(that.getLabel());
    }
}
