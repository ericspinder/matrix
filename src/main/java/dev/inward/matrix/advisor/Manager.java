package dev.inward.matrix.advisor;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Roller;

import java.io.Serializable;


public abstract class Manager<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,M extends Manager<Y,F,O,I,X,B,P,M>> implements Comparable<M>, Serializable {

    /**
     *
     * @param roller
     * @param envoy
     * @param <DATUM>
     * @param <D>
     * @param <V>
     * @return try again?
     */
    public abstract  <DATUM,D extends Datum<DATUM,D,V,F,I,X,P>,V extends Envoy<DATUM,D,V,F,I,X,P>> boolean handle(Roller roller,V envoy);

}
//    private class ExceptionCounterByDuration {
//        private LinkedHashMap<Instant, Boolean> linkedHashMap = new LinkedHashMap<Instant, Boolean>() {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Instant, Boolean> eldest) {
//                return Instant.now().minus(qualifyingTime).isAfter(eldest.getKey());
//            }
//        };
//        private final Duration qualifyingTime;
//        private final int numberOfOccurrences;
//
//        public ExceptionCounterByDuration(Duration qualifyingTime, int numberOfOccurrences) {
//            this.qualifyingTime = qualifyingTime;
//            this.numberOfOccurrences = numberOfOccurrences;
//
//        }
//        public Boolean addOne() {
//            if (this.numberOfOccurrences > linkedHashMap.size()) {
//                this.linkedHashMap.put(Instant.now(), true);
//                return true;
//            }
//            this.linkedHashMap.put(Instant.now(), false);
//            return false;
//        }
//    public <D extends Datum<Y,D,F,O,I,X,B,P>> D create() {
//        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue,this.getClass());
//    }

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
