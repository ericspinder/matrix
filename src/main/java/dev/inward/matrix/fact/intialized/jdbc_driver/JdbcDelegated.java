package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.intialized.Delegated;

import java.lang.ref.ReferenceQueue;

public class JdbcDelegated extends Delegated<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated> {


    public JdbcDelegated(JdbcConnection fact, ReferenceQueue<JdbcConnection> referenceQueue, JdbcBook bus, JdbcFunctionary operational) {
        super(fact, referenceQueue, bus, operational);
    }
}
