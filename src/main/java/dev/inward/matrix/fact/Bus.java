package dev.inward.matrix.fact;

import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Bus<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R>,
        R extends Representative<F,I,X,R,?,?>> implements Runnable {

        protected final UUID uuid = UUID.randomUUID();
        protected ConcurrentLinkedDeque<R> deque;
        protected final Complication predictor;

        @SuppressWarnings("unchecked")
        public Bus() {
        }
        public void addPassenger(R representative) {
                this.deque.add(representative);
        }

        @Override
        public void run() {
                this.register(deque.poll());
        }

        private final void register(R representative) {
                for (Criterion<?> criterion: representative.getStandard().getCriteria(Z)) {
                        criterion
                }
                return this.predictor.engage()
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


