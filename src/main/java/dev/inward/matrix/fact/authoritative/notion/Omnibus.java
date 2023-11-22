package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;

public class Omnibus<N extends Notion<N,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,I extends Identity<I,ID,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Context.Governance<N,VERSION,I,ID,EXPIRE,G>,O extends Omnibus<N,I,ID,X,O,A,T>,A extends Agent<N,I,X,A>,T extends Itinerary<N,S,I,X,O,A,T>> extends Bus<N,I,X,O,A,T> {

    public Omnibus(M driver) {
        super(driver);
    }
}
