package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.intialized.Functionary;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class JdbcFunctionary extends Functionary<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated> {

    public JdbcFunctionary(Specification specification, Supplier<JdbcManager, JdbcConnection, JdbcFunctionary, Identity.Ego, Context.Demarc, JdbcBook, JdbcDelegated, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
