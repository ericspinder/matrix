package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.meta.Meta;

import java.io.Serializable;

public abstract class Reckoning<S extends Reckoning<S>> extends Meta<S> implements Comparable<S>, Serializable {

    public Reckoning(String label, String description, String i18n, S defaultValue) {
        super(label, description, i18n, defaultValue);
    }

    /**
     * 
     * @return
     */
    public abstract Boolean isGoodThing();
}
