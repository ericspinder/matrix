package dev.inward.matrix.fact.datum.time;

import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

public class GenericDateDatum<DATUM, D extends GenericDateDatum<DATUM,D,V,IC,XC,G>,V extends Envoy<DATUM,D,V,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>,G extends GenericDateMeta<DATUM,D,V,IC,XC,G>> extends Datum<DATUM,D,V,IC,XC> {
}
