package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.advisor.Manager;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Supervisor<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,O>,P extends Primogenitor<Y,N,S,I,X,O,P>,M extends Supervisor<Y,N,S,I,X,O,P,M>> extends Manager<Y,N,S,I,X,O,P,M> {


    @Override
    public int compareTo(M o) {
        return 0;
    }
}
