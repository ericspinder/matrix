package dev.inward.matrix.meta.time;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.meta.Meta;

public class Date<D extends Datum<D,?,?,?,?,?>,M extends Date<D,M>> extends Meta<D,M> {

    public Date(String label, String description, String i18n) {
        super(label, description, i18n);
    }

}
