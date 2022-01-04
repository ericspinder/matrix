package com.notionds.dataSupplier;

import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public class Bus<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,B>,X extends Context<D,O,C,X>,B extends Bus<D,O,C,X,B,A,P,M>, A extends Advisor<D,O,C,X,A,?>,P extends Provider<D,O,C,X>,M extends Meta<D>> {

        protected transient volatile A advisor;
        private final UUID uuid;
        protected O operational;
        protected P provider;
        protected final M meta;
        private final StampedLock memberGate = new StampedLock();

        public Bus(final UUID uuid, A advisor, final M meta, P provider, O operational) {
                this.uuid = uuid;
                this.advisor = advisor;
                this.meta = meta;
                this.provider = provider;
                this.operational = operational;
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

