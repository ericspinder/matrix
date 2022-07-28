package dev.inward.matrix.fact.intialized.jdbc_driver;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.intialized.Intialized;

import java.sql.Connection;

public abstract class JdbcConnection extends Intialized<JdbcConnection, Identity.Ego, Context.JVM> implements Connection {

    public JdbcConnection(Identity.Ego id) {
        super(id);
    }

}
