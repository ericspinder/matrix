/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.*;
import dev.inward.matrix.concept.fact.addressed.depot.indica.Indica;
import dev.inward.matrix.concept.fact.addressed.log.Log;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.WatchKey;
import java.nio.file.Watchable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.StampedLock;

public class Complication<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET>> implements Runnable {

    protected final StampedLock gate = new StampedLock();
    protected final UUID uuid = UUID.randomUUID();
    protected final ConcurrentLinkedDeque<Log> competedLogs = new ConcurrentLinkedDeque<>();
    protected final Predictable predictable;
    protected final Provider<TARGET> provider;

    protected boolean queuedForExecution = false;
    protected boolean canceled = false;
    protected Policy<Bout<TARGET>,?>[] allPolicies;


    @SuppressWarnings("unchecked")
    public Complication(Predictable predictable, Provider<TARGET> provider, Map<Indica,Criterion> criterionByIndicaMap) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.predictable = predictable;
        this.provider = provider;
        List<Policy<Bout<TARGET>,?>> policies = new ArrayList<>();
        for (Indica indica : criterionByIndicaMap.keySet()) {
            Criterion criterion = criterionByIndicaMap.get(indica);
            if (!indica.getCriterionClassName().equals(criterion.getClass().getCanonicalName())) {
                throw new RuntimeException("indica and criterion mismatch" + indica.toString() + ", " + criterion.getLabel() + " - " + criterion.getClass());
            }
            policies.add((Policy<Bout<TARGET>,?>) Class.forName(indica.getPolicyClassName()).getConstructor(Complication.class, Indica.class, Criterion.class).newInstance(this, indica, criterion));
        }
        this.allPolicies = policies.toArray(new Policy[0]);
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
    public void run() {
        if (provider.hasNext()) {
            try {
                Bout<DATUM, V, M, R, G> bout = new Bout<>(provider.next());

            } finally {
                this.canceled = true;
            }
        }
        else {
            if (provider.isCancelWhenResetIsFalse()) {
                this.canceled = true;
            }
        }
    }

    public void cancel() {
        this.canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
