package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.phenomenon.producer.ExecutionExceptionly;

import java.io.Serializable;
import java.lang.invoke.*;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.Watchable;
import java.util.List;

public class Complication<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CRIT extends Criterion,P extends Predictable<S,L,PATH,ID,T,C,CRIT,P,COMP>,COMP extends Complication<S,L,PATH,ID,T,C,CRIT,P,COMP>> implements WatchKey {

    protected final CRIT criterion;
    protected final P predictable;
    protected final Class<Aspect<S,L,PATH,ID,T,C>> aspect;


    public Complication(CRIT criterion, P predictable,Class<Aspect<S,L,PATH,ID,T,C>> aspect) {
        this.criterion = criterion;
        this.predictable = predictable;
        this.callSite = predictable.registerCriterion(criterion);
    }
    public void engage(Bus<> bus, E envoy) throws ExecutionExceptionly {
        MethodHandle methodHandle = callSite.getTarget();
        predictable.complete(this.criterion, envoy, methodHandle);

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
        return false;
    }

    /**
     * Retrieves and removes all pending events for this watch key, returning
     * a {@code List} of the events that were retrieved.
     *
     * <p> Note that this method does not wait if there are no events pending.
     *
     * @return the list of the events retrieved; may be empty
     */
    @Override
    public List<WatchEvent<?>> pollEvents() {
        return null;
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
        return false;
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
    public Watchable watchable() {
        return this.predictable;
    }
}
//        suppressors("Suppressor",""),
//        confounders("confounders",""),
//        covariates("convariates"),
//        mediators("mediator",""),
//        moderators("",""),
