package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.sanction.Sanction;

import java.io.Serializable;


public abstract class Advisor<D extends Datum<?,D,C>,C extends Container<D,C>,A extends Advisor<D,C,A>> implements Comparable<A>, Serializable {

    public <T extends Throwable, S extends Sanction> void handle(T t,D datum,C container) {
        new Breaker<D,?,?,?,T>();
    }
    public C newContainer() {

    }

    public D create() {
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue,this.getClass());
    }

//    public boolean addNotion(D wrapper, boolean returned) {
//        if (returned) {
//            this.loanedNotions.remove(wrapper);
//            if (!(wrapper.getContainer().getBridge().returnToPool(wrapper))) {
//                log.error("ConnectionId=" + ((Datum)added).getContainer().containerId + " was not able to reuse, will close");
//                (wrapper.getContainer().closeDelegate());
//                return false;
//            }
//        }
//        if (evalForSpaceInPool() && connectionQueue.add(added)) {
//            ((Datum)added).getContainer().currentState = Matter.State.Provider;
//            log.debug("ConnectionId=" + ((Datum)added).getContainer().containerId + " was added/re-added to Notion provider, queue_size=" + connectionQueue.size());
//            return true;
//        } else {
//            log.error("ConnectionId=" + ((Datum)added).getContainer().containerId + " was not able to add Notion provider, queue_size=" + connectionQueue.size());
//            ((Datum)added).getContainer().closeDelegate(((Datum)added));
//            return false;
//        }
//    }
//
//    public void addNotionFutures(Supplier<Container<DELEGATE,O,?>> newNotionSupplier, int notionsToAdd) {
//        if (notionsToAdd >= options.getInteger(Minimum_Replenishment.getI18n())) {
//            for (int i = 0; i < notionsToAdd; i++) {
//                CompletableFuture.supplyAsync(() -> this.addNotion(newNotionSupplier.get(), false), connectionExecutor);
//            }
//        }
//        else {
//            log.debug("No need to fill notionsToAdd=" + notionsToAdd);
//        }
//    }
//    public boolean addNotionNow(Supplier<Container<DELEGATE,O,?>> newNotionSupplier) {
//        return this.addNotion(newNotionSupplier.get(), false);
//    }
//
//    /**
//     * Drains and closes the current connection provider and marks them all loaned to be close when no longer in use, rather than returned to the provider.
//     */
//    public void drainAllCurrentConnections() {
//        List<Datum> drain = new ArrayList<>();
//        this.connectionQueue.drainTo(drain);
//        this.loanedNotions.keySet().stream().forEach((Datum loaned) -> loaned.getContainer().currentState = Matter.State.Empty);
//        drain.forEach((Datum artifactI) -> artifactI.getContainer().closeDelegate(artifactI));
//
//    }


}