package dev.inward.matrix.meta;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public interface Meta_I<DATUM extends Comparable<DATUM> & Serializable,M extends Meta_I<DATUM,M>> extends Comparable<M> {

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
    default Class<DATUM> getDatumClass() {
        return ((Class<DATUM>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    default int compareTo(M that) {
        return this.getLabel().compareTo(that.getLabel());
    }
}
