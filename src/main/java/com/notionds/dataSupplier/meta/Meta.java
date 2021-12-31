package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.options.Options;

import java.io.Serializable;

public abstract class Meta<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O,D>, C extends Container<DATUM,O,C,D,B>,D extends Datum<DATUM,O,C,D,B>,B extends Bus<DATUM,O,C,D,B,?,?,?>> implements Meta_I {

    private final String name;
    private final String description;
    private final String i18n;

    public Meta(String name, String description, String i18n) {
        this.name = name;
        this.description = description;
        this.i18n = i18n;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getI18n() {
        return i18n;
    }

}
