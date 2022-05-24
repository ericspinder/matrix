package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.advisor.Manager;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Roller;

public class Supervisor<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P>,P extends Ambassador<Y,N,S,I,X,O,P>,M extends Supervisor<Y,N,S,I,X,O,P,M>> extends Manager<Y,N,S,I,X,O,P,M> {


    @Override
    public int compareTo(M o) {
        return 0;
    }

    @Override
    public <D extends Datum<D, N, I, X, P, E>, E extends Envoy<Y, D, N, S, I, X, O, P, E>> D handle(Roller roller, E envoy) {
        return null;
    }
}
