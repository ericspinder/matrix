package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Volume;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Structure extends Volume<BootLoader,Boot,Init, Context.Platform.JVM,Structure,Root> {

    public Structure(Init operational, Map<Criteria, Criterion[]> criteriaMap) {
        super(operational, criteriaMap);
    }
}
