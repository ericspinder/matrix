package dev.inward.matrix.datum.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Submarine<NP extends Notion<NP, Identity.Ego<Context.JVM>,Context.JVM,PP>,PP extends Ambassador<?,NP,?,Identity.Ego<Context.JVM>, Context.JVM,?,PP>> extends Bus<Factory_ofPools<NP,PP>,Pool<NP,PP>,Operational_ofPool<NP,PP>, Identity.Ego<Context.JVM>, Context.JVM,Submarine<NP,PP>,LifeGuard<NP,PP>,NP,PP> {


    public Submarine(Operational_ofPool<NP, PP> operational, Map<Criteria<Factory_ofPools<NP, PP>, Pool<NP, PP>, Operational_ofPool<NP, PP>, Identity.Ego<Context.JVM>, Context.JVM, Submarine<NP, PP>, LifeGuard<NP, PP>, NP, PP>, Criterion<Factory_ofPools<NP, PP>, ?, Pool<NP, PP>, Operational_ofPool<NP, PP>, Identity.Ego<Context.JVM>, Context.JVM, Submarine<NP, PP>, LifeGuard<NP, PP>, NP, PP, ?, ?, ?>[]> criteriaMap) {
        super(operational, criteriaMap);
    }
}
