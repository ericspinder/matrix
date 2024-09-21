package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.intialized.jdbc_driver.ConnectionState;
import dev.inward.matrix.setting.Security;

import java.sql.Connection;
import java.util.Properties;

public abstract class Operational {

    protected final Security security;

    // protected final Options
    protected final Properties properties;
    public Operational(Security security Properties properties) {
        this.security = security;
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public static class JDBCOperational<C extends Connection> extends Operational {

        public JDBCOperational(Properties properties) {
            super(properties);
        }
    }
}
