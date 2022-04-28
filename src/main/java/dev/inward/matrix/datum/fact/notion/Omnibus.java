package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Omnibus<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,P>,P extends Primogenitor<Y,N,S,I,X,O,P>> extends Bus<Y,N,S,I,X,O,P,N,P> {

    public Omnibus(S operational, Map<Criteria.NotionCriteria<Y, N, O, I, X, O, P>, Criterion<Y,?,N,O,I,X,O,P,N,P,?,?,?>[]> criteriaMap) {
        super(operational, criteriaMap);
    }
}
