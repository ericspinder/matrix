/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.MatrixItem;
import dev.inward.matrix.MatrixKey;
import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.file.addressed.log.Matter;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.StampedLock;

public abstract class Complication<K extends MatrixKey<K,I>,I extends MatrixItem<K,I>> implements WatchKey {

    protected final StampedLock gate = new StampedLock();
    protected final UUID uuid = UUID.randomUUID();
    protected final ConcurrentLinkedDeque<Matter> competedMatters = new ConcurrentLinkedDeque<>();
    protected final Predictable predictable;
    protected final K matrixKey;
    protected final ComplicationCriterion<K,I> complicationCriterion;

    protected Boolean working = null;

    protected int maxMattersToDistribute = 500;

    protected Map<Policy<K,I,?>,Boolean> allActivePolicies = new HashMap<>();


    public Complication(Predictable predictable, K matrixKey, ComplicationCriterion<K,I> complicationCriterion, Map<Indica,PolicyCriterion<K,I,?>> policyCriterionByIndicaMap) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.predictable = predictable;
        this.matrixKey = matrixKey;
        this.complicationCriterion = complicationCriterion;
        for (Indica indica: policyCriterionByIndicaMap.keySet()) {
            PolicyCriterion<K,I,?> policyCriterion = policyCriterionByIndicaMap.get(indica);
            if (!indica.getPolicyCriterionClassName().equals(policyCriterion.getClass().getCanonicalName())) {
                throw new RuntimeException(indica + " has wrong policyClassName for " + policyCriterion.getClass().getCanonicalName());
            }
            Policy<K,I,?> policy = (Policy<K, I,?>) Class.forName(indica.getPolicyClassName()).getConstructor(Complication.class, Indica.class,PolicyCriterion.class).newInstance(this,indica,policyCriterion);
            if (policyCriterion.autoStart) {
                complicationCriterion.getRoad(matrixKey,predictable.getDirector()).execute(policy);
            }
        }

//        while(criteria.hasNext()) {
//            Criterion criterion = criteria.next();
//            int position = Arrays.binarySearch(neededCriteriaClassNames,criterion.getClassName());
//            if (position >= 0) {
//                this.criteria.add(criterion);
//                System.arraycopy(neededCriteriaClassNames, position + 1, neededCriteriaClassNames, position, neededCriteriaClassNames.length - 1 - position);
//                if (criterion.isSingleCustomer()) {
//                    criteria.remove();
//                }
//                if (autoStart) {
//                    // once set to false, do not allow reset of autoStart, all matched criteria must be set to autostart
//                    autoStart = criterion.isAutoStart();
//                }
//            }
//        }
//        if (provider.getCriterion()) {
//
//        }
//        if (neededCriteriaClassNames.length != 0 && checkCriteria()) {
//            if (autoStart) {
//                this.working = start();
//            }
//        }
//        else {
//            System.out.println("Needed Criteria remaining = " + neededCriteriaClassNames.length + "; checkCriteria() = " + checkCriteria());
//            for (String remainingClassName : neededCriteriaClassNames) {
//                System.out.println(remainingClassName);
//            }
//            this.working = false;
//        }
    }

    public K getMatrixKey() {
        return matrixKey;
    }

    private boolean start() {
        return this.setUp();
    }
    protected boolean setUp() {
        return true;
    }

//    @SuppressWarnings("unchecked")
//    public final void run() {
//        if (working == null || working) throw new MatrixException(MatrixException.Type.RunProblem,"Complication was set as working or cancelled", Indicia.Focus.Assembly, Occurrence.Severity.Critical,new Exception("stack trace..."));
//        long writeLock = gate.writeLock();
//        try {
//            this.working = true;
//            M matter = currentMatter;
//            if (currentMatter == null) {
//                matter = matterSupplier.get();
//            }
//            for (Policy<S,L,PATH,W,OCCURRENCE> policy: policies()) {
//                if (policy.getDesign().isSingleton()) {
//                    OCCURRENCE occurrence = policy.apply(provider.next());
//                    if (occurrence_response != null) {
//                        matter.add(occurrence);
//                    }
//                }
//                else {
//                    for ()
//                }
//            }
//            if (this.currentOccurrence !=null) {
//                matter.count()
//            }
//            this.working = false;
//        }
//        catch (Throwable throwable) {
//            this.predictable.getCatalog().processFailure(this, new MatrixException(MatrixException.Type.RunProblem,this.getClass().getCanonicalName(), Indicia.Focus.Admonitory, Occurrence.Severity.Exceptional,throwable));
//        }
//        finally {
//            gate.unlockWrite(writeLock);
//        }
//    }

    /**
     * Tells if this watch info is valid.
     *
     * <p> A watch info is valid upon creation and remains until it is cancelled,
     * or its watch service is closed.
     *
     * @return {@code true} if, and only if, this watch info is valid
     */
    @Override
    public boolean isValid() {
        return this.working != null;
    }

    @Override
    public List<WatchEvent<?>> pollEvents() {
//        List<WatchEvent<?>> events = new ArrayList<>();
//        while(!competedMatters.isEmpty() && events.size() < ) {
//
//        }
        return null;
    }

    /**
     * Resets this watch info.
     *
     * <p> If this watch info has been cancelled or this watch info is already in
     * the ready state then invoking this method has no effect. Otherwise
     * if there are pending events for the object then this watch info is
     * immediately re-queued to the watch service. If there are no pending
     * events then the watch info is put into the ready state and will remain in
     * that state until an event is detected or the watch info is cancelled.
     *
     * @return {@code true} if the watch info is valid and has been reset, and
     * {@code false} if the watch info could not be reset because it is
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
     * Cancels the registration with the watch service. Upon return the watch info
     * will be invalid. If the watch info is enqueued, waiting to be retrieved
     * from the watch service, then it will remain in the queue until it is
     * removed. Pending events, if any, remain pending and may be retrieved by
     * invoking the {@link #pollEvents pollEvents} method after the info is
     * cancelled.
     *
     * <p> If this watch info has already been cancelled then invoking this
     * method has no effect.  Once cancelled, a watch info remains forever invalid.
     */
    @Override
    public void cancel() {
        this.working = null;
    }

    /**
     * Returns the object for which this watch info was created. This method will
     * continue to return the object even after the info is cancelled.
     *
     * <p> As the {@code WatchService} is intended to map directly on to the
     * native file event notification facility (where available) then many of
     * details on how registered objects are watched is highly implementation
     * specific. When watching a directory for changes for example, and the
     * directory is moved or renamed in the file system, there is no guarantee
     * that the watch info will be cancelled and so the object returned by this
     * method may no longer be a valid path to the directory.
     *
     * @return the object for which this watch info was created
     */
    @Override
    public K watchable() {
        return this.matrixKey;
    }
}
