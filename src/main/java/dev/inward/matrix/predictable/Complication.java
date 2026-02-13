/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.*;
import dev.inward.matrix.item.datum.indica.Indica;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.StampedLock;

public class Complication<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Complication<TARGET,V,M,C>> implements Runnable, Comparable<C> {

    protected final StampedLock gate = new StampedLock();
    protected final UUID uuid = UUID.randomUUID();
    protected final Complicated<TARGET,V,M,C> complicated;
    protected final ConcurrentLinkedDeque<Bout<TARGET,V,M,C>> competedBouts = new ConcurrentLinkedDeque<>();
    protected final Map<Chit<TARGET,V,M>, Instant> registeredOpenChits = new WeakHashMap<>();
    protected final Provider<TARGET> provider;

    protected boolean queuedForExecution = false;
    protected boolean canceled = false;

    protected Policy<Bout<TARGET,V,M,C>,?>[] allPolicies;


    @SuppressWarnings("unchecked")
    public Complication(Complicated<TARGET,V,M,C> complicated, Provider<TARGET> provider, Map<Indica,Criterion> criterionByIndicaMap) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.complicated = complicated;
        this.provider = provider;
        List<Policy<Bout<TARGET,V,M,?>,?>> policies = new ArrayList<>();
        for (Indica indica : criterionByIndicaMap.keySet()) {
            Criterion criterion = criterionByIndicaMap.get(indica);
            if (!indica.getCriterionClassName().equals(criterion.getClass().getCanonicalName())) {
                throw new RuntimeException("indica and criterion mismatch" + indica.toString() + ", " + criterion.getLabel() + " - " + criterion.getClass());
            }
            policies.add((Policy<Bout<TARGET,V,M,C>,?>) Class.forName(indica.getPolicyClassName()).getConstructor(Complication.class, Indica.class, Criterion.class).newInstance(this, indica, criterion));
        }
        this.allPolicies = policies.toArray(new Policy[0]);
    }
    public List<Bout<TARGET,V,M,C>> pollEvents(Chit<TARGET,V,M> chit) {
        List<Bout<TARGET,V,M,C>> targetedBouts = new ArrayList<>();
        for (Bout<TARGET,V,M,C> competedBout: competedBouts) {
            TARGET chitTarget = chit.targetReference.get();
            if (chitTarget != null && chitTarget.equals(competedBout.getTarget())) {
                targetedBouts.add(competedBout);
            }
        }
        if (registeredOpenChits.containsKey(chit)) {
            registeredOpenChits.put(chit, Instant.now());
        }
        return targetedBouts;
    }

    public Map<Chit<TARGET, V, M>, Instant> getRegisteredOpenChits() {
        return registeredOpenChits;
    }

    public UUID getUuid() {
        return uuid;
    }
    pu

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
        if (canceled) {
            throw new CancellationException("canceled");
        }
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

    @Override
    public int compareTo(@NotNull C that) {
        int isZero = this.getClass().getCanonicalName().compareTo(that.getClass().getCanonicalName());
        return 0;
    }

    public boolean isCanceled() {
        return canceled;
    }
    public void wrapUp() {
        this.cancel();
    }
}
