package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Meta<DATUM extends Comparable<DATUM> & Serializable> implements Operational.Option<DATUM> {

    private String label;
    private String description;
    private String i18n;
    private DATUM defaultValue;

    public Meta(String label, String description, String i18n, DATUM defaultValue) {
        this.label = label;
        this.description = description;
        this.i18n = i18n;
        this.defaultValue = defaultValue;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public String getI18n() {
        return i18n;
    }
    public DATUM getDefaultValue() {
        return this.defaultValue;
    }

}
