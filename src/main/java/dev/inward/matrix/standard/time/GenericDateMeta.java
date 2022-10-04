package dev.inward.matrix.standard.time;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import crud.Meta;
import dev.inward.matrix.datum.Envoy;

public abstract class GenericDateMeta<DATUM, D extends GenericDateDatum<DATUM,D,V,IC,XC,G>,V extends Envoy<DATUM,D,V,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>,G extends GenericDateMeta<DATUM,D,V,IC,XC,G>> extends Meta<DATUM,G> {

    public GenericDateMeta(String label, String description, String i18n) {
        super(label, description, i18n);
    }

}
