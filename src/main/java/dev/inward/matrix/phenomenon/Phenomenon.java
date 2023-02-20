package dev.inward.matrix.phenomenon;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.phenomenon.producer.CanceledExceptionally;
import dev.inward.matrix.phenomenon.producer.InterruptionExceptionally;
import dev.inward.matrix.phenomenon.producer.TimeoutExceptionally;
import dev.inward.matrix.phenomenon.producer.ExecutionExceptionly;
import dev.inward.matrix.route.Road;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.time.Duration;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class Phenomenon<MAT extends Matter<MAT,I,ID,VERSION,X>,I extends Identity<I,ID,VERSION,X>,ID extends Comparable<ID>,VERSION extends Comparable<VERSION>,X extends Context<VERSION,X>> implements Serializable, Comparable<Phenomenon>, Future<M> {

    protected final Governance.Ethereal ethereal;
    protected SoftReference<MAT> remains;
    protected final SoftReference<Road> road;

    protected Phenomenon(Governance.Ethereal ethereal, SoftReference<Road> road) {
        this.ethereal = ethereal;
        this.road = road;
    }

    public boolean nowProcessing() {
        return  startTime != null && remains.get() == null;
    }

    public final MAT matter() {
        if (this.remains != null) {
            return this.remains.get();
        }
        return null;
    }

    public final void setRemains(MAT remains) {
        if (this.remains == null) {
            this.remains = new SoftReference<>(remains);
        }
        else {
            throw new NotionStartupException(NotionStartupException.Type.SoftReference_Problem,this.getClass(), Indicia.Focus.Type, Indicia.Severity.Exceptional,new Exception("Cannot set a Soft Reference twice"));
        }
    }


    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        this.remains = new Canceled(mayInterruptIfRunning);
        this.road.get().
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
    public MAT get() throws InterruptionExceptionally, ExecutionExceptionly, CanceledExceptionally {
        try {
            return get(this.tolerances().);
        }
        catch (TimeoutExceptionally timeoutExceptionally) {
            this.cancel(true);
            throw new CanceledExceptionally(,"default timeout of future");
        }
    }


    @Override
    public M get(long timeout, TimeUnit unit) throws InterruptionExceptionally, CanceledExceptionally, TimeoutExceptionally {
        return this.get(Duration.of(timeout,unit.toChronoUnit()));
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
