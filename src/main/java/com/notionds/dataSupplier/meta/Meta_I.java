package com.notionds.dataSupplier.meta;

import java.lang.reflect.ParameterizedType;

public interface Meta_I<DATUM> {

    String getLabel();
    String getI18n();
    String getDescription();
    default Class<DATUM> getDatumClass() {
        return ((Class<DATUM>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
