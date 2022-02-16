package com.notionds.dataSupplier.operational;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.rubric.Complication;

public final class ComplicationOption<I extends Id<I,X>,X extends Context<X>,D extends Datum<?,D,?,?,?>,COMP extends Complication<I,X,D,?,?,?,?,?,?,COMP>,CO extends ComplicationOption<I,X,D,COMP,CO>> extends Meta<COMP,CO> implements Operational.Option<COMP,CO> {

    protected final COMP defaultValue;

    public ComplicationOption(String label, String description, String i18n, COMP defaultValue) {
        super(label,description,i18n);
        this.defaultValue = defaultValue;
    }

    @Override
    public int compareTo(CO that) {
        return super.compareTo(that);
    }

    @Override
    public COMP getDefaultValue() {
        return this.defaultValue;
    }
}
