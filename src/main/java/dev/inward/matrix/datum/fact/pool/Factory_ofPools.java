package dev.inward.matrix.datum.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Factory_ofPools<NP extends Notion<NP, Identity.Ego<Context.JVM>,Context.JVM,PP>,PP extends Primogenitor<?,NP,?,Identity.Ego<Context.JVM>, Context.JVM,?,PP>> extends Factory<Factory_ofPools<NP,PP>, Pool<NP,PP>, Operational_ofPool<NP,PP>, Identity.Ego<Context.JVM>,Context.JVM, Submarine<NP,PP>, LifeGuard<NP,PP>,NP,PP> {

    public Factory_ofPools(Progenitor progenitor, LinkedBlockingDeque<Operational_ofPool> operationalDeque, Map<Class<?>, List<Predictor<Factory_ofPools, ?, Pool, Operational_ofPool, Identity.Ego<Context.JVM>, Context.JVM, Submarine, LifeGuard, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }
    @Override
    public int compareTo(Factory_ofPools that) {
        return this.uuid.compareTo(that.uuid);
    }

}
