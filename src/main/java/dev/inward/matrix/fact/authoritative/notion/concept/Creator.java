package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Capability;

public class Creator<FAB extends Fabrication<FAB,C,T, U,M>,DATUM,D extends Datum<DATUM,D,U,C,Identity.Ego, Context.Demarc,M>,V extends Envoy<DATUM,D,V,C,>,C extends Concept<C>,T extends Effect<FAB,C,T, U,M>, U extends Volume<FAB,C,T, U,M>,M extends Mortal<FAB,C,T, U,M>> extends Capability<FAB,> {
}
