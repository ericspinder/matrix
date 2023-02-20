package dev.inward.matrix.fact.datum.time;

import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

import java.time.Instant;

public class InstantDatum<V extends Envoy<Instant,InstantDatum<V,IC,XC>,V,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends GenericDateDatum<Instant,InstantDatum<V,IC,XC>,V,IC,XC,Instant> {


}
