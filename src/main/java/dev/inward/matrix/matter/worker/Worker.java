package dev.inward.matrix.matter.worker;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.edition.Edition;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.matter.Matter;

import java.lang.ref.SoftReference;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Worker<PRODUCT,R extends Worker<PRODUCT,R,CI,CX>, CI extends Identity<CI, CX>, CX extends Context<CX>> extends Matter<R,CI,CX> implements Future<PRODUCT> {

    protected SoftReference<PRODUCT> product;
    protected final Duration defaultTimeout;
    protected final long sleep;
    protected final long snooze;

    public Worker(UUID uuid, CI containerId, Instant createInstant, String locus) {
        super(uuid, containerId, createInstant, new Indicia(locus, Indicia.Focus.Assembly, Indicia.Severity.Nominal));
        this.defaultTimeout = (Duration)((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().specification().getOptions().get("dev.inward.matrix.matter.retainer.Retainer.defaultTimeout");
        this.sleep = (long)((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().specification().getOptions().get("dev.inward.matrix.matter.retainer.Retainer.sleep");
        this.snooze = (long)((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().specification().getOptions().get("dev.inward.matrix.matter.retainer.Retainer.snooze");
    }

    public final PRODUCT getProduct() {
        if (this.product != null) {
            return this.product.get();
        }
        return null;
    }
    public final void setProduct(PRODUCT product) {
        if (this.product == null) {
            this.product = new SoftReference<>(product);
        }
        else {
            throw new NotionStartupException(NotionStartupException.Type.SoftReference_Problem,this.getClass(), Indicia.Focus.Type, Indicia.Severity.Exceptional,new Exception("Cannot set a Soft Reference twice"));
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        this.product = new Canceled(mayInterruptIfRunning);
        return true;
    }

    @Override
    public boolean isCancelled() {
        return product != null && product.get() == null;
    }

    @Override
    public boolean isDone() {
        return this.product != null && this.product.get() != null;
    }

    @Override
    public PRODUCT get() throws Interruption_ofTopic, Canceled_forTopic {
        try {
            return get(this.defaultTimeout);
        }
        catch (WaitTimout_forTopic timeout) {
            this.cancel(true);
            throw new Canceled_forTopic(this.uuid,this.containerId,"default timeout of future");
        }
    }

    @Override
    public PRODUCT get(long timeout, TimeUnit unit) throws Interruption_ofTopic, Canceled_forTopic, WaitTimout_forTopic {
        return this.get(Duration.of(timeout,unit.toChronoUnit()));
    }
    public PRODUCT get(Duration timeout) throws Interruption_ofTopic, Canceled_forTopic, WaitTimout_forTopic {
        PRODUCT response = (this.product != null)? this.product.get(): null;
        if (response != null) {
            return response;
        }
        for (;;) {
            if (Thread.interrupted()) {
                throw new Interruption_ofTopic(this.uuid, this.containerId, "Interruption of future");
            }
            if (this.isCancelled()) {
                throw new Canceled_forTopic(this.uuid, this.containerId,"Cancelled future");
            }
            response = (this.product != null)? this.product.get(): null;
            if (response != null) {
                return response;
            }
            long startNano = System.nanoTime();
            try {
                Thread.sleep(this.sleep, 10);
            }
            catch (InterruptedException ie) {
                throw new Interruption_ofTopic(this.uuid,this.containerId,"Interruption during sleep of future");
            }
            long elapsed = System.nanoTime() - startNano;
            if (elapsed < this.snooze) {
                Map<String,Object> details = new HashMap<>();
                details.put("Version", Edition.Version.Aforementioned.get());
                details.put("elapsed nano",elapsed);
                details.put("planned sleep",this.sleep);
                details.put("snooze nano",this.snooze);
                ((Factory)(this.getClass().getClassLoader())).getEngine().getOperational().report(this, details);
            }
        }
    }
    protected class Canceled extends SoftReference<PRODUCT> {
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
