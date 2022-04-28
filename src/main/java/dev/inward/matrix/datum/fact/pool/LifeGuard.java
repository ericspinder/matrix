package dev.inward.matrix.datum.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class LifeGuard<NP extends Notion<NP, Identity.Ego<Context.JVM>,Context.JVM,PP>,PP extends Primogenitor<?,NP,?,Identity.Ego<Context.JVM>, Context.JVM,?,PP>> extends Progenitor<Factory_ofPools<NP,PP>, Pool<NP,PP>, Operational_ofPool<NP,PP>, Identity.Ego<Context.JVM>,Context.JVM, Submarine<NP,PP>, LifeGuard<NP,PP>,NP,PP> {

    public LifeGuard(Pool fact, ReferenceQueue<Pool<NP,PP>> referenceQueue, Submarine bus, Operational_ofPool operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
