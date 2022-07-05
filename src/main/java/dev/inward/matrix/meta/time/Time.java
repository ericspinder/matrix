package dev.inward.matrix.meta.time;

import dev.inward.matrix.meta.Meta;
import dev.inward.matrix.operational.Specification;

import java.io.Serializable;

public abstract class Time<DATUM extends Comparable<DATUM> & Serializable,T extends Time<DATUM,T>> extends Meta<DATUM,T> {

    protected Specification.Option[] timeOptions;

    public Time(String label, String description, String i18n) {
        super(label, description, i18n);
    }
}
