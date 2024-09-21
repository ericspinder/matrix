package dev.inward.matrix.fact.authoritative.notion.concept;

import crud.Protocol;
import crud.Volume;
import dev.inward.matrix.fact.datum.Ware;

public interface Ledger<C extends Protocol<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Construct<C,M>> {

    boolean forRemoval(Ware ware);
}
