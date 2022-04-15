package com.notionds.jdbc;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Progenitor_holdingJdbcDs extends Progenitor<Factory_forJdbcDs, JdbcDs,Operational_ofJdbcDs, Identity.Ego<Context.JVM>,Context.JVM,Bus_forJdbcDs,Progenitor_holdingJdbcDs> {

    public Progenitor_holdingJdbcDs(JdbcDs fact, ReferenceQueue<JdbcDs> referenceQueue, Bus_forJdbcDs bus, Operational_ofJdbcDs operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
