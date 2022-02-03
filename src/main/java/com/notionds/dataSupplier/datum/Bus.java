package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

import java.util.concurrent.locks.StampedLock;

public class Bus<D extends Fact<D,O,C,I>,O extends Operational<D,O>,C extends Support<D,O,C,I,B>,I extends Ego<?,?,I,?>,B extends Bus<D,O,C,I,B,A,P,M>, A extends Advisor<D,O,C,I,A>,P extends Provider<D,O,C,I,P>,M extends Meta<D,M>> {

        protected transient volatile A advisor;
        protected final O operational;
        protected final P provider;
        protected final M meta;
        private final StampedLock memberGate = new StampedLock();

        public Bus(final M meta,final O operational,final A advisor,final P provider) {
                this.meta = meta;
                this.operational = operational;
                this.advisor = advisor;
                this.provider = provider;
        }
        public final M getMeta(C container) {
                return meta;
        }
        public final A getAdvisor(C container) {
                long readLock = memberGate.readLock();
                try {
                        return this.advisor;
                } finally {
                        memberGate.unlockRead(readLock);
                }
        }
        public final P getProvider(C container) {
                long readLock = memberGate.readLock();
                try {
                        return this.provider;
                }
                finally {
                        memberGate.unlockRead(readLock);
                }
        }

        public final O getOperational(C container) {
                long readLock = memberGate.readLock();
                try {
                        return this.operational;
                }
                finally {
                        memberGate.unlockRead(readLock);
                }
        }
        public final void setAdvisor(A advisor) {
                long writeLock = memberGate.writeLock();

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

