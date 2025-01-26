package dev.inward.matrix.predictable;

import dev.inward.matrix.*;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.log.Matter;

import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.StampedLock;

public abstract class Complication<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,R,F>,FILE extends MatrixFile<PATH,K,FILE,R,F>,R extends Registar<PATH,K,FILE,R,F>,F extends FileAttributes<PATH,K,FILE,R,F>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> implements WatchKey {

    protected final StampedLock gate = new StampedLock();
    protected volatile M currentMatter;
    protected final ConcurrentLinkedDeque<M> competedMatters = new ConcurrentLinkedDeque<>();
    protected volatile OCCURRENCE currentOccurrence;
    private final Provider<PATH,K> provider;
    private final Matter.ChainSupplier<M,OCCURRENCE> matterSupplier;
    protected final List<Criterion> criteria = new ArrayList<>();

    protected Boolean working = null;

    protected int maxMattersToDistribute = 500;

    /**
     *
     * @return
     */
    protected boolean checkCriteria() {
                return true;
            }

    public int getMaxMattersToDistribute() {
        return maxMattersToDistribute;
    }

    public void setMaxMattersToDistribute(int maxMattersToDistribute) {
        this.maxMattersToDistribute = maxMattersToDistribute;
    }

    protected abstract Policy<PATH,,OCCURRENCE>[] policies();

    public Complication(Provider<W> provider, Matter.ChainSupplier<M,OCCURRENCE> matterSupplier, Iterator<Criterion> criteria) {
        this.provider = provider;
        this.matterSupplier = matterSupplier;
        boolean autoStart = true;
        String[] neededCriteriaClassNames = Arrays.copyOf(matterSupplier.path.criteriaClassNames(),matterSupplier.path.criteriaClassNames().length);
        while(criteria.hasNext()) {
            Criterion criterion = criteria.next();
            int position = Arrays.binarySearch(neededCriteriaClassNames,criterion.getClassName());
            if (position >= 0) {
                this.criteria.add(criterion);
                System.arraycopy(neededCriteriaClassNames, position + 1, neededCriteriaClassNames, position, neededCriteriaClassNames.length - 1 - position);
                if (criterion.isSingleCustomer()) {
                    criteria.remove();
                }
                if (autoStart) {
                    // once set to false, do not allow reset of autoStart, all matched criteria must be set to autostart
                    autoStart = criterion.isAutoStart();
                }
            }
        }
        if (provider.getCriterion()) {

        }
        if (neededCriteriaClassNames.length != 0 && checkCriteria()) {
            if (autoStart) {
                this.working = start();
            }
        }
        else {
            System.out.println("Needed Criteria remaining = " + neededCriteriaClassNames.length + "; checkCriteria() = " + checkCriteria());
            for (String remainingClassName : neededCriteriaClassNames) {
                System.out.println(remainingClassName);
            }
            this.working = false;
        }
    }
    private boolean start() {
        return this.setUp();
    }
    protected boolean setUp() {
        return true;
    }

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
            for (Policy<S,L,PATH,W,OCCURRENCE> policy: policies()) {
                if (policy.getDesign().isSingleton()) {
                    OCCURRENCE occurrence = policy.apply(provider.next());
                    if (occurrence_response != null) {
                        matter.add(occurrence);
                    }
                }
                else {
                    for ()
                }
            }
            if (this.currentOccurrence !=null) {
                matter.count()
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
     * Tells if this watch key is valid.
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
