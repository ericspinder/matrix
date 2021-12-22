package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static com.notionds.dataSupplier.operational.DurationOption.ConnectionMaxLifetime;

public class Advisor<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,?,?,?,?>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>> {

    private static final Logger log = LogManager.getLogger(Advisor.class);

    protected boolean doCleanup = true;
    private final Map<U, Instant> timeoutCleanup = Collections.synchronizedMap(new WeakHashMap<>());

    /**
     * The max time a Notion will be allowed to stay active.
     */
    private Duration maxConnectionLifetime;

    public Advisor(O options) {
        this.maxConnectionLifetime = options.getDuration(ConnectionMaxLifetime.getI18n());
    }



    /**
     * Patrol for ConnectionContainer timeouts
     */
    protected void patrolForNewTimeouts() {
        for (Map.Entry<U, Instant> returnedWrapped: timeoutCleanup.entrySet()) {
            Instant expireTime = returnedWrapped.getValue();
            if (expireTime != null && expireTime.isAfter(Instant.now())) {
                if (returnedWrapped.getKey() instanceof Container) {
                    U wrapped = returnedWrapped.getKey();
                    wrapped.getContainer().closeDelegate();
                    log.error("Timeout for ConnectionId=" + wrapped.getContainer().containerId);
                }
                else {
                    Container.DoDelegateClose(returnedWrapped.getKey());
                    throw new NotionStartupException(NotionStartupException.Type.Timeout_On_Non_Containerized_Notion, null);
                }
            }
        }
    }



    public void run() {
//        try {
            while (doCleanup) {
                checkForRecyclables();
                patrolForNewTimeouts();
            }
//        }
//        catch (InterruptedException ie) {
//            return;
//        }
    }
    public Duration getMaxConnectionLifetime() {
        return maxConnectionLifetime;
    }

    public void setMaxConnectionLifetime(Duration maxConnectionLifetime) {
        this.maxConnectionLifetime = maxConnectionLifetime;
    }
}
