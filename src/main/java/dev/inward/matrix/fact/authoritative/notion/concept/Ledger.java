package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.fact.datum.Envoy;

public interface Ledger<C extends Protocol<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Construct<C,M>> {

    boolean forRemoval(Envoy envoy);
}
