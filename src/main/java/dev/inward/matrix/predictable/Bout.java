/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Model;
import dev.inward.matrix.View;
import dev.inward.matrix.item.datum.log.LogEntry;
import dev.inward.matrix.route.Ticket;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public sealed abstract class Bout<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M,C>> implements WatchEvent<C> permits Bout.Uninterested, Bout.Interested {

    private final C complication;
    private final AtomicInteger count = new AtomicInteger();
    protected final TARGET target;
    protected final Map<String, Ticket<?>> targetAttributes;

    public Bout(C complication, TARGET target, Map<String, Ticket<?>> targetAttributes) {
        this.complication = complication;
        this.target = target;
        this.targetAttributes = targetAttributes;
    }

    public final synchronized <LE extends LogEntry> int finalizeLogEntry(LE logEntry) {
        int value = count.incrementAndGet();
        offerLogEntry(logEntry);
        if (value == Integer.MAX_VALUE) {
            count.set(Integer.MIN_VALUE);
        }
        return value;
    }
    public final TARGET getTarget() {
        return target;
    }
    protected abstract void offerLogEntry(LogEntry logEntry);

    @SuppressWarnings( "unchecked")
    @Override
    public Complicated<TARGET,V,M,C> kind() {
        return this.complication.complicated;
    }

    @Override
    public int count() {
        return count.intValue();
    }

    @Override
    public C context() {
        return this.complication;
    }

    public static final class Uninterested<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M,C>> extends Bout<TARGET,V,M,C> {

        public Uninterested(C complication, TARGET startingTarget, Map<String, Ticket<?>> targetAttributes) {
            super(complication, startingTarget,targetAttributes);
        }

        @Override
        protected void offerLogEntry(LogEntry logEntry) {

        }
    }
    public static final class Interested<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M,C>> extends Bout<TARGET,V,M,C> {

        private final List<LogEntry> logEntries = new ArrayList<>();
        public Interested(C complication, TARGET startingTarget, Map<String, Ticket<?>> targetAttributes) {
            super(complication, startingTarget,targetAttributes);
        }
        @Override
        protected void offerLogEntry(LogEntry logEntry) {
            this.logEntries.add(logEntry);
        }
    }
}
