package com.notionds.dataSupplier.meta;

import java.lang.reflect.ParameterizedType;

public interface Meta_I<DATUM> {

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
}
