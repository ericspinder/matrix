package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Volume;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Calc extends Volume<Bakery,Evaluate,Batch,Context.Service,Calc,Existent> {

    public Calc(Batch operational, Map<Criteria, Criterion[]> criteriaMap) {
        super(operational, criteriaMap);
    }
}
