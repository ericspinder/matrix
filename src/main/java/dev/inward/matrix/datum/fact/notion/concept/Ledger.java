package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

public interface Ledger<FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<C,M>> {

    boolean forRemoval(Envoy envoy);
}
