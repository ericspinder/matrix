package dev.inward.matrix.fact.datum;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.ticket.Ticket;

import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.Watchable;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Complication<PATH extends Comparable<PATH>,D extends Datum<D,E>,E extends Envoy<D,E>,C extends Complication<PATH,D,E,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> implements WatchKey {

    protected final StampedLock gate = new StampedLock();
    protected volatile M currentMatter;
    protected final ConcurrentLinkedDeque<M> competedMatters = new ConcurrentLinkedDeque<>();
    protected volatile OCCURRENCE currentOccurrence;
    private final Provider<D> provider;
    private final Supplier<M> matterSupplier;
    protected final List<Criterion> criteria = new ArrayList<>();

    protected Boolean working;

    protected int maxMattersToDistribute = 500;

    /**
     * This default implementation takes every Criterion based on the results of the accept(Criterion) method. An accepted Criterion is queried about it's 'singleCustomer' field if true then it will recommend removal.
     * @param criterion the instructions
     * @return true if it should be removed from the list of criteria for the 'next' complication created, if there is another Indicia to process
     */
    protected boolean bogart(Criterion criterion) {
        return this.accept(criterion) && criterion.isSingleCustomer();
    }

    /**
     * This default implementation will accept any Criterion which either matches complicationClassName or is blank.
     * @param criterion the criteria to be accepted
     * @return true if has been accepted, false otherwise
     */
    protected boolean accept(Criterion criterion) {
        if (criterion.getComplicationClassName().equals(this.getClass().getCanonicalName()) || criterion.getComplicationClassName().isEmpty()) {
            this.criteria.add(criterion);
            return true;
        }
        return false;
    }

    public int getMaxMattersToDistribute() {
        return maxMattersToDistribute;
    }

    public void setMaxMattersToDistribute(int maxMattersToDistribute) {
        this.maxMattersToDistribute = maxMattersToDistribute;
    }

    protected abstract Policy<? extends Function<C,OCCURRENCE>,PATH,D,E,C,M,OCCURRENCE>[] policies();

    public Complication(Provider<D> provider, Supplier<M> matterSupplier, Iterator<Criterion> criteria, boolean autostart) {
        this.provider = provider;
        this.matterSupplier = matterSupplier;
        while(criteria.hasNext()) {
            if (bogart(criteria.next())) {
                criteria.remove();
            }
        }
        if (autostart) {
            this.working = start();
        }
    }
    protected Boolean start() {
        boolean setUp = this.setUp(true);
        if (!setUp) {
            return null;
        }
        else {
            return true;
        }
    }
    protected abstract boolean setUp(boolean first);

    @SuppressWarnings("unchecked")
    public final void run() {
        if (working == null || working) throw new MatrixException(MatrixException.Type.RunProblem,"Complication was set as working or cancelled", Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("stack trace..."));
        long writeLock = gate.writeLock();
        try {
            this.working = true;
            M matter = currentMatter;
            if (currentMatter == null) {
                matter = matterSupplier.get();
            }
            for (Policy<? extends Function<C,OCCURRENCE>,PATH,W,C,M,OCCURRENCE> policy: policies()) {
                OCCURRENCE occurrence_response = policy.getBehavior().apply((C)this);
                if (occurrence_response != null) {
                    this.currentOccurrence = occurrence_response;
                }
            }
            if (this.currentOccurrence !=null) {

            }
            this.working = false;
        }
        catch (Throwable throwable) {
            this.predictable.getCatalog().processFailure(this, new MatrixException(MatrixException.Type.RunProblem,this.getClass().getCanonicalName(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,throwable));
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

    /**
     * Tells whether or not this watch key is valid.
     *
     * <p> A watch key is valid upon creation and remains until it is cancelled,
     * or its watch service is closed.
     *
     * @return {@code true} if, and only if, this watch key is valid
     */
    @Override
    public boolean isValid() {
        return this.working != null;
    }

    @Override
    public List<WatchEvent<?>> pollEvents() {
        List<WatchEvent<?>> events = new ArrayList<>();
        while(!competedMatters.isEmpty() && events.size() < ) {

        }
    }

    /**
     * Resets this watch key.
     *
     * <p> If this watch key has been cancelled or this watch key is already in
     * the ready state then invoking this method has no effect. Otherwise
     * if there are pending events for the object then this watch key is
     * immediately re-queued to the watch service. If there are no pending
     * events then the watch key is put into the ready state and will remain in
     * that state until an event is detected or the watch key is cancelled.
     *
     * @return {@code true} if the watch key is valid and has been reset, and
     * {@code false} if the watch key could not be reset because it is
     * no longer {@link #isValid valid}
     */
    @Override
    public boolean reset() {
        if (this.isValid()) {
            long writeLock = gate.writeLock();
            try {

                return true;
            }
            finally {
                gate.unlockWrite(writeLock);
            }
        }
        else {
            return false;
        }
    }

    /**
     * Cancels the registration with the watch service. Upon return the watch key
     * will be invalid. If the watch key is enqueued, waiting to be retrieved
     * from the watch service, then it will remain in the queue until it is
     * removed. Pending events, if any, remain pending and may be retrieved by
     * invoking the {@link #pollEvents pollEvents} method after the key is
     * cancelled.
     *
     * <p> If this watch key has already been cancelled then invoking this
     * method has no effect.  Once cancelled, a watch key remains forever invalid.
     */
    @Override
    public void cancel() {
        this.working = null;
    }

    /**
     * Returns the object for which this watch key was created. This method will
     * continue to return the object even after the key is cancelled.
     *
     * <p> As the {@code WatchService} is intended to map directly on to the
     * native file event notification facility (where available) then many of
     * details on how registered objects are watched is highly implementation
     * specific. When watching a directory for changes for example, and the
     * directory is moved or renamed in the file system, there is no guarantee
     * that the watch key will be cancelled and so the object returned by this
     * method may no longer be a valid path to the directory.
     *
     * @return the object for which this watch key was created
     */
    @Override
    public W watchable() {
        return this.provider.next();
    }
}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
