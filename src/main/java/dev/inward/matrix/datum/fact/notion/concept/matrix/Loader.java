package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Volume;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Loader extends Volume<Construct,Matrix,Interface, Context.Service,Loader,Architect> {

    public Loader(Interface operational, Map<Criteria<Matrix, Identity.Ego<Context.Service>,Context.Service,Architect,Matrix,Architect>, Criterion<?,?,?,Matrix, Identity.Ego<Context.Service>,Context.Service,Architect,Matrix,Architect,?>[]> criteriaMap) {
        super(operational,criteriaMap);
    }
}
