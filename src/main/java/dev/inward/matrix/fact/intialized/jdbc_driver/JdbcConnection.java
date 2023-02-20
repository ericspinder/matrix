package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.intialized.Intialized;
import dev.inward.matrix.fact.Context;

import java.sql.Connection;

public abstract class JdbcConnection extends Intialized<JdbcConnection, Identity.Ego, Context.Demarc> implements Connection {

    public JdbcConnection(Identity.Ego id) {
        super(id);
    }

}
