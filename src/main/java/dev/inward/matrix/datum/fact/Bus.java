package dev.inward.matrix.datum.fact;

import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Envoy;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.UUID;
import java.util.concurrent.Callable;

public class Bus<F extends Fact<F,I,X,NI,NX>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R,N,NI,NX,A,U,P,M,T>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,
        U extends Router<F,I,X,B,R,N,NI,NX,A,U,P,M,T>,P extends Phenomenon<M,P,T>,M extends Matter<M,I,X>,T extends Tolerances<M,T>> implements Runnable,Callable<M>,Comparable<B> {

        protected final UUID uuid = UUID.randomUUID();
        protected final A driver;
        protected final ThreadedRepresentative<F,I,X,R,NI,NX> threadedRepresentative = new ThreadedRepresentative<>();

        @SuppressWarnings("unchecked")
        public Bus(A driver) {
                this.driver = driver;
        }

        public void addPickup(R representative) {
                this.threadedRepresentative.set(representative);
                return;
        }

        @Override
        public void run() {
                System.out.println(this.ride(this.threadedRepresentative.get()));
        }
        @Override
        public M call() {
               return ride(this.threadedRepresentative.get());
        }
        protected M ride(R representative) {

        }

        public <DATUM,D extends Datum<DATUM,D,V>,V extends Envoy<DATUM,D,V>,M extends Matter>  add(V datum) {
                R pickup = this.threadedRepresentative.get();
                if (pickup == null) {
                        throw new NotionStartupException(NotionStartupException.Type.Pickup_Not_Set,getClass(), Indicia.Focus.Assembly, Indicia.Severity.Critical, null);
                }
                Factory<?,F,?,I,X,B,R,N,NI,NX,A,?,U> factory = ((Factory<?, F, ?, I, X, B, R, N, NI, NX, A, ?, U>) getClass().getClassLoader());
                factory.getEngine().
        }

        @Override
        public int compareTo(B that) {
                return this.uuid.compareTo(that.uuid);
        }
}
//        public DATUM take(Proffer proffer, Task[] tasks, boolean isWriteLock) {
//                long lock;
//                if(!isWriteLock) lock = memberGate.readLock();
//                else lock = memberGate.writeLock();
//                try {
//                        N wrapped = this.provider.getWrappedReady();
//                        if (wrapped.getContainer().checkout(advisor.add(wrapped,tasks))) {
//                                return (DATUM) wrapped;
//                        }
//                        return null;
//                }
//                finally {
//                        if(isWriteLock) memberGate.unlockWrite(lock);
//                        memberGate.unlockRead(lock);
//                }
//        }
//
//        public Promise<DATUM> get(Task[] tasks, boolean isWriteLock) {
//                long lock;
//                if(isWriteLock) lock = memberGate.writeLock();
//                else lock = memberGate.readLock();
//                try {
//
//                }
//                finally {
//                        if(!isWriteLock) memberGate.unlockRead(lock);
//                        else memberGate.unlockWrite(lock);
//                }
//                return null;
//        }
//        public DATUM get(Promise<DATUM> producer) {
//                long lock = memberGate.readLock();
//                try {
//
//                }
//                finally {
//                        memberGate.unlockRead(lock);
//                }
//                return null;
//        }
//        /**
//         * Wraps an existing delegate into a notion. It will be set as Situation.Closed_Failure if not suitable for use.
//         * @param DATUM the delegate
//         * @param args an array of Objects for the constructor, Strings may sometimes be assumed by default, they should match the forth and such constructor parameters
//         * @param tasks the tasks to be associated with this notion. Cleanup instructions
//         * @return The wrapped delegate, but it might be closed, check to see if Situation.Open before use, unless you're feeling lucky or irrelevant.
//         */
//        @SuppressWarnings("unchecked")
//        public N wrap(DATUM DATUM, Object[] args, Task[] tasks) {
//                C container = (C) notionSupplier.getNewContainer(operational);
//                N wrapped = notion.wrapNotion(container, DATUM, args);
//                if (!wrapped.getContainer().checkout(advisor.add(wrapped, tasks))) {
//                        logger.error("delegate was not suitable for wrapping or just unneeded, let it go");
//                }
//                return wrapped;
//        }


