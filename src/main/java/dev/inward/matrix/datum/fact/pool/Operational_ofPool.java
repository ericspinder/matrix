package dev.inward.matrix.datum.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

public class Operational_ofPool<NP extends Notion<NP, Identity.Ego<Context.JVM>,Context.JVM,PP>,PP extends Ambassador<?,NP,?,Identity.Ego<Context.JVM>, Context.JVM,?,PP>> extends Operational<Factory_ofPools<NP,PP>, Pool<NP,PP>, Operational_ofPool<NP,PP>, Identity.Ego<Context.JVM>,Context.JVM, Submarine<NP,PP>, LifeGuard<NP,PP>,NP,PP> {
    public Operational_ofPool(Specification specification, Supplier supplier) {
        super(specification, supplier);
    }
}
