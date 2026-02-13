/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Model;
import dev.inward.matrix.View;
import dev.inward.matrix.item.datum.log.LogEntry;

import java.nio.file.WatchEvent;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Bout<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M,C>> implements WatchEvent<C> {

    private final C complication;
    protected final AtomicInteger count = new AtomicInteger();
    protected final TARGET target;

    public Bout(C complication, TARGET target) {
        this.complication = complication;
        this.target = target;
    }
    public final <LE extends LogEntry> void finalizedPolicyLog(LE logEntry) {
        count.incrementAndGet();

    }
    public final TARGET getTarget() {
        return target;
    }
    protected abstract void examineLogEntry(LogEntry logEntry);

    @SuppressWarnings( "unchecked")
    @Override
    public Complicated<TARGET,V,M,C> kind() {
        return (Complicated<TARGET,V,M,C>) this.complication.complicated;
    }

    @Override
    public int count() {
        return count.intValue();
    }

    @Override
    public C context() {
        return this.complication;
    }

    public static final class Uninterested<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M>> extends Bout<TARGET,V,M,C> {

        public Uninterested(C complication, TARGET startingTarget) {
            super(complication, startingTarget);
        }

        @Override
        protected void examineLogEntry(LogEntry logEntry) {

        }
    }
}
