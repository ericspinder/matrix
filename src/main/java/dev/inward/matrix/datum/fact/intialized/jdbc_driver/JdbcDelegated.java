package dev.inward.matrix.datum.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Delegated;

import java.lang.ref.ReferenceQueue;

public class JdbcDelegated extends Delegated<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated> {


    public JdbcDelegated(JdbcConnection fact, ReferenceQueue<JdbcConnection> referenceQueue, JdbcBook bus, JdbcFunctionary operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
