package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

import java.util.Arrays;
import java.util.concurrent.locks.StampedLock;

public class Bus<F extends Fact<F,O,?,I,X,B>,O extends Operational<F,O>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,O,I,X,B>> {

        protected volatile Advisor[] advisors;
        protected O operational;
        private final StampedLock memberGate = new StampedLock();

        public Bus(O operational, Advisor[] advisors) {
                this.operational = operational;
                this.advisors = advisors;
        }
        public final Advisor[] getAdvisors() {
                long readLock = memberGate.readLock();
                try {
                        return this.advisors;
                } finally {
                        memberGate.unlockRead(readLock);
                }
        }
        public final O getOperational() {
                long readLock = memberGate.readLock();
                try {
                        return this.operational;
                }
                finally {
                        memberGate.unlockRead(readLock);
                }
        }
        public final void addAdvisor(Advisor advisor) {
                long writeLock = memberGate.writeLock();
                try {
                        advisors = Arrays.copyOf(this.advisors,advisors.length + 1);
                        advisors[advisors.length -1] = advisor;
                }
                finally{
                        memberGate.unlockWrite(writeLock);
                }
        }
        public final void removeAdvisor(Advisor advisor) {
                long writeLock = memberGate.writeLock();
                try {
                        this.advisors = Arrays.stream(this.advisors)
                                .filter(a -> !a.equals(advisor)).toArray(Advisor[]::new);
                }
                finally{
                        memberGate.unlockWrite(writeLock);
                }
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
//        public DATUM get(Promise<DATUM> promise) {
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

