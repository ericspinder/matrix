package dev.inward.matrix.datum.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Pool<NP extends Notion<NP, Identity.Ego<Context.JVM>,Context.JVM,PP>,PP extends Primogenitor<?,NP,?,Identity.Ego<Context.JVM>, Context.JVM,?,PP>> extends Fact<Pool<NP,PP>, Identity.Ego<Context.JVM>,Context.JVM, LifeGuard<NP,PP>> {

    private static final String TTL_PROP = "networkaddress.cache.ttl";


    private final Integer dnsTimeout;

    public Pool(Identity.Ego<Context.JVM> identity) {
        super(identity);

    }

//    /**
//     * A connection test which will lock out the normal 'acquireConnection' method
//     * @return
//     */
//    public Connection testConnection() throws Roller {
//        long writeLock = connectionGate.writeLock();
//        try {
//            Datum connection = newConnectionContainer();
//            if (connection != null) {
//                return (Connection) connection;
//            }
//            throw new NotionStartupException(NotionStartupException.Type.TEST_CONNECTION_FAILURE, Pool.class, Subject.Focus.Admonitory, Subject.Severity.Exceptional,null);
//        }
//        finally {
//            connectionGate.unlockWrite(writeLock);
//        }
//    }

}

