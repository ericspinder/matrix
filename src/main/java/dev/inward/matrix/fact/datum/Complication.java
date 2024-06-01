package dev.inward.matrix.fact.datum;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.concept.matter.limitReached.LimitReached;
import dev.inward.matrix.ticket.Ticket;

import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Predicate;

public abstract class Complication<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CRIT extends Criterion,P extends Predictable<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,COMP extends Complication<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> implements WatchKey, Runnable {

    protected final StampedLock gate = new StampedLock();
    protected final P predictable;
    protected final CRIT criterion;
    protected volatile M currentMatter;

    protected final Provider<S,L,PATH,ID,T,C> provider;



    public Complication(P predictable, CRIT criterion, Provider<S,L,PATH,ID,T,C> provider) {
        this.predictable = predictable;
        this.criterion = criterion;
        this.provider = provider;
    }

    public static class Limitation<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Complication<S,L,PATH,ID,T,C, Criterion.Limiter,Predictable.Limited<S,L,PATH,ID,T,C>, Limitation<S,L,PATH,ID,T,C>, LimitReached<S,L,PATH,ID,T,C>> {

        public Limitation(Predictable.Limited<S,L,PATH,ID,T,C> limited, Criterion.Limiter limiter, Provider<S,L,PATH,ID,T,C> provider) {
            super(limited, limiter, provider);
        }

    }

    public final void run() {
        long writeLock = gate.writeLock();
        try {
            M matter = this.call();
            this.isSettled(matter);
            mattersTickets.put(matter,);
        }
        catch (Throwable throwable) {
            this.predictable.getCatalog().processFailure(this, new MatrixException(MatrixException.Type.RunProblem,this.getClass().getCanonicalName(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e));
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

    public abstract Ticket<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>[] isSettled(M matter);

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
        return this.provider.isOn();
    }

    @Override
    public List<WatchEvent<?>> pollEvents() {
        return List.of((WatchEvent<?>) this.pollEvents("anyone").stream());
    }
    public List<M> pollEvents(Ticket<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE> ticketStub) {
        long readLock = gate.readLock();
        try {
            List<M> events = new ArrayList<>();
            for (Map.Entry<M, Ticket<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>[]> matterEntry : mattersTickets.entrySet()) {
                for (Ticket<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE> ticket : matterEntry.getValue()) {
                    if (ticket.equals() && matterEntry.getKey().isSettled()) {
                        events.add(matterEntry.getKey());
                        matterEntry.setValue((String[]) Arrays.stream(matterEntry.getValue()).dropWhile(Predicate.isEqual(subscription)).toArray());
                    }
                }
            }
            return events;
        }
        finally {
            gate.unlockRead(readLock);
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
                this.mattersTickets.forEach(Matter::setSettled);
                this.mattersTickets.clear();
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
        this.provider.off();
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
    public T watchable() {
        return this.provider.getConcept().getIdentity();
    }
}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
