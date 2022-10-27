package dev.inward.matrix.phenomenon;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.report.Report;
import dev.inward.matrix.phenomenon.producer.Interruption;
import dev.inward.matrix.phenomenon.producer.Timout;
import dev.inward.matrix.phenomenon.producer.WorkException;

import java.lang.ref.SoftReference;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class Phenomenon<M extends Matter<M,?,?>,P extends Phenomenon<M,P,T>,T extends Tolerances<M,T>> implements Comparable<P>, Future<M> {

    protected final Context.Ethereal ethereal;
    protected SoftReference<M> remains;
    protected T tolerances;

    protected Phenomenon(Context.Ethereal ethereal, T tolerances) {
        this.ethereal = ethereal;
        this.tolerances = tolerances;
    }

    public T tolerances() {
        return this.tolerances;
    }

    public final Identity identity() {
        return this.ethereal;
    }

    public final M matter() {
        if (this.remains != null) {
            return this.remains.get();
        }
        return null;
    }

    public final void setRemains(M remains) {
        if (this.remains == null) {
            this.remains = new SoftReference<>(remains);
        }
        else {
            throw new NotionStartupException(NotionStartupException.Type.SoftReference_Problem,this.getClass(), Indicia.Focus.Type, Indicia.Severity.Exceptional,new Exception("Cannot set a Soft Reference twice"));
        }
    }

    public void setTolerances(T tolerances) {
        this.tolerances = tolerances;
    }

    public Identity.Ghost ghost() {
        return ghost;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        this.remains = new Canceled(mayInterruptIfRunning);
        return true;
    }

    @Override
    public boolean isCancelled() {
        return remains != null && remains.get() == null;
    }

    @Override
    public boolean isDone() {
        return this.remains != null && this.remains.get() != null;
    }

    @Override
    public M get() throws Interruption, WorkException, dev.inward.matrix.phenomenon.producer.Canceled {
        try {
            return get(this.tolerances().);
        }
        catch (Timout timeout) {
            this.cancel(true);
            throw new dev.inward.matrix.phenomenon.producer.Canceled(,"default timeout of future");
        }
    }

    @Override
    public M get(long timeout, TimeUnit unit) throws Interruption, dev.inward.matrix.phenomenon.producer.Canceled, Timout {
        return this.get(Duration.of(timeout,unit.toChronoUnit()));
    }
    public M get(Duration timeout) throws Interruption, dev.inward.matrix.phenomenon.producer.Canceled, Timout {
        M response = (this.remains != null)? this.remains.get(): null;
        if (response != null) {
            return response;
        }
        Instant timeoutInstant = Instant.now().plus(timeout);
        for (;;) {
            if (Thread.interrupted()) {
                throw new Interruption(this.uuid, this.containerId, "Interruption");
            }
            if (this.isCancelled()) {
                throw new dev.inward.matrix.phenomenon.producer.Canceled(this.uuid, this.containerId,"Cancelled");
            }
            if (Instant.now().isAfter(timeoutInstant)) {
                throw new Timout(this.uuid,this.containerId,"Timeout");
            }
            response = (this.remains != null)? this.remains.get(): null;
            if (response != null) {
                return response;
            }
            long startNano = System.nanoTime();
            try {
                Thread.sleep(this.sleep, 10);
            }
            catch (InterruptedException ie) {
                throw new Interruption(this.uuid,this.containerId,"Interruption during sleep of future");
            }
            long elapsed = System.nanoTime() - startNano;
            if (elapsed < this.snooze) {
                Map<String,Object> details = new HashMap<>();
                details.put("Version", Edition.Version.Aforementioned.get());
                details.put("elapsed nano",elapsed);
                details.put("planned sleep",this.sleep);
                details.put("snooze nano",this.snooze);
                ((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().report(new Report(UUID.randomUUID(),this.containerId,Instant.now(),new Indicia("Over snoozed", Indicia.Focus.Admonitory, Indicia.Severity.Timer),details));
            }
        }
    }
    protected class Canceled extends SoftReference<M> {
        protected final boolean scheduledForInterruption;
        public Canceled(boolean scheduledForInterruption) {
            super(null);
            this.scheduledForInterruption = scheduledForInterruption;
        }
        public final boolean isScheduledForInterruption() {
            return this.scheduledForInterruption;
        }
    }

}
