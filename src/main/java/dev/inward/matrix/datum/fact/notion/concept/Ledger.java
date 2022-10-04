package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Envoy;

public interface Ledger<FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<C,M>> {

    boolean forRemoval(Envoy envoy);
}
