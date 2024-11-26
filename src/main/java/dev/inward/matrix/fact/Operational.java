package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.intialized.jdbc_driver.ConnectionState;
import dev.inward.matrix.setting.Security;

import java.security.cert.CertPath;
import java.sql.Connection;
import java.util.Properties;

public abstract class Operational {

    protected final CertPath[] certPaths;

    // protected final Options
    protected final Properties properties;
    public Operational(CertPath[] certPaths, Properties properties) {
        this.certPaths = certPaths;
        this.properties = properties;
    }

    public CertPath[] getCertPaths() {
        return certPaths;
    }

    public Properties getProperties() {
        return properties;
    }

    public static class JDBCOperational<C extends Connection> extends Operational {

        public JDBCOperational(CertPath[] certPaths, Properties properties) {
            super(certPaths, properties);
        }
    }
}
