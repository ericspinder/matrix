package com.notionds.jdbc;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Referenced;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

public class Factory_forJdbcDs extends Factory<Factory_forJdbcDs,JdbcDs, Operational_ofJdbcDs, Identity.Ego<Context.JVM>,Context.JVM,Bus_forJdbcDs,Progenitor_holdingJdbcDs> {

    public Factory_forJdbcDs(Progenitor progenitor, LinkedBlockingDeque<Operational_ofJdbcDs> operationalDeque, Map<Class<?>, List<Predictor<Factory_forJdbcDs, ?, JdbcDs, Operational_ofJdbcDs, Identity.Ego<Context.JVM>, Context.JVM, Bus_forJdbcDs, Progenitor_holdingJdbcDs, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }
    @Override
    public int compareTo(Factory_forJdbcDs that) {
        return this.uuid.compareTo(that.uuid);
    }

}
