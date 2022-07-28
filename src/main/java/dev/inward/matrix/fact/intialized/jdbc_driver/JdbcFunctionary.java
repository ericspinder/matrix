package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.intialized.Functionary;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class JdbcFunctionary extends Functionary<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.JVM, JdbcBook, JdbcDelegated> {

    public JdbcFunctionary(Specification specification, Supplier<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.JVM, JdbcBook, JdbcDelegated, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
