package dev.inward.matrix.datum.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.intialized.Functionary;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class JdbcFunctionary extends Functionary<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Ethereal, JdbcBook, JdbcDelegated> {

    public JdbcFunctionary(Specification specification, Supplier<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Ethereal, JdbcBook, JdbcDelegated, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
