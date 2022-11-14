package dev.inward.matrix.fact.datum.time;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Envoy;

public abstract class GenericDateMeta<DATUM, D extends GenericDateDatum<DATUM,D,V,IC,XC,G>,V extends Envoy<DATUM,D,V,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>,G extends GenericDateMeta<DATUM,D,V,IC,XC,G>> extends Meta_I.Meta<DATUM,G> {

    public GenericDateMeta(String label, String description, String i18n) {
        super(label, description, i18n);
    }

}
