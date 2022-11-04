package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Root;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Startup;

import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Bus<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O,N,NI,NX,M,T>,B extends Bus<F,I,X,O,B,N,NI,NX,M,T>,
        N extends Notion<N,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>,
        M extends Matter<M,I,X>,T extends Tolerances<M,T>> implements Runnable,Callable<M>,Comparable<B> {

        protected final UUID uuid = UUID.randomUUID();
        protected final ThreadedAgent<N,NI,NX> threadedAgent = new ThreadedAgent<>();
        protected final ThreadedRepresentative<F,I,X,NI,NX> threadedRepresentative = new ThreadedRepresentative<>();

        protected final O operational;
        protected ConcurrentLinkedDeque<Representative<F,I,X,?,NI,NX>> deque;

        @SuppressWarnings("unchecked")
        public Bus(O operational) {
                this.operational = operational;
        }
        public void addPassenger(F fact, NI containerId) {
                Startup.root().get();
        }

        @Override
        public void run() {
                System.out.println(this.ride(deque.poll()));
        }
        @Override
        public M call() {
               return ride(deque.poll());
        }

        private final M ride(Representative<F,I,X,?,NI,NX> representative) {
                if (!(representative instanceof Root)) {
                        if (!(representative instanceof Agent)) {
                                Agent<N,NI,NX,?> agent = threadedAgent.get();
                                this.threadedRepresentative.set(representative);
                        return;

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


