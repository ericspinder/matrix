package dev.inward.matrix.fact.datum.time;

import dev.inward.matrix.View;
import dev.inward.matrix.fact.datum.Ware;
import dev.inward.matrix.Context;

public abstract class GenericDateView<DATUM, D extends GenericDateDatum<DATUM,D,V,IC,XC,G>,V extends Ware<DATUM,D,V,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>,G extends GenericDateView<DATUM,D,V,IC,XC,G>> extends View<DATUM,G> {

    public GenericDateView(String label, String description, String i18n) {
        super(label, description, i18n);
    }

}
