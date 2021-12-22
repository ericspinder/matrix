package com.notionds.dataSupplier;

import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Proffer;
import com.notionds.dataSupplier.task.Task;
import com.notionds.dataSupplier.provider.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.locks.StampedLock;

public class Bus<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,N,A,P,M>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>, N extends Notion<NOTION,O,B,C,U>,A extends Advisor<NOTION,O,B,C,U>,P extends Provider<NOTION,O,B,C,U>,M extends Meta<NOTION,O,B,C,U>> {

        private static final Logger logger = LogManager.getLogger();
        private transient final Factory factory;
        private transient final ClassLoader classLoader;
        protected final O operational;
        protected final N delegation;
        protected P provider;
        protected A advisor;
        protected M meta;
        protected ReferenceQueue<U> globalReferenceQueue = new ReferenceQueue<>();
        private final StampedLock memberGate = new StampedLock();

        public Bus(final Factory<?> factory, final ClassLoader classLoader, final O operational, final N delegation, final A advisor, final P provider, final M meta, final ) {
                this.factory = factory;
                this.classLoader = classLoader;
                this.operational = operational;
                this.delegation = delegation;
                this.provider = provider;
                this.advisor = advisor;
                this.meta = meta;
        }

        @SuppressWarnings("unchecked")
        public NOTION take(Proffer proffer, Task[] tasks, boolean isWriteLock) {
                long lock;
                if(!isWriteLock) lock = memberGate.readLock();
                else lock = memberGate.writeLock();
                try {
                        N wrapped = this.provider.getWrappedReady();
                        if (wrapped.getContainer().checkout(advisor.add(wrapped,tasks))) {
                                return (NOTION) wrapped;
                        }
                        return null;
                }
                finally {
                        if(isWriteLock) memberGate.unlockWrite(lock);
                        memberGate.unlockRead(lock);
                }
        }

        public Promise<NOTION> get(Task[] tasks, boolean isWriteLock) {
                long lock;
                if(isWriteLock) lock = memberGate.writeLock();
                else lock = memberGate.readLock();
                try {

                }
                finally {
                        if(!isWriteLock) memberGate.unlockRead(lock);
                        else memberGate.unlockWrite(lock);
                }
                return null;
        }
        public NOTION get(Promise<NOTION> promise) {
                long lock = memberGate.readLock();
                try {

                }
                finally {
                        memberGate.unlockRead(lock);
                }
                return null;
        }
        /**
         * Wraps an existing delegate into a notion. It will be set as Situation.Closed_Failure if not suitable for use.
         * @param NOTION the delegate
         * @param args an array of Objects for the constructor, Strings may sometimes be assumed by default, they should match the forth and such constructor parameters
         * @param tasks the tasks to be associated with this notion. Cleanup instructions
         * @return The wrapped delegate, but it might be closed, check to see if Situation.Open before use, unless you're feeling lucky or irrelevant.
         */
        @SuppressWarnings("unchecked")
        public N wrap(NOTION NOTION, Object[] args, Task[] tasks) {
                C container = (C) notionSupplier.getNewContainer(operational);
                N wrapped = delegation.wrapNotion(container, NOTION, args);
                if (!wrapped.getContainer().checkout(advisor.add(wrapped, tasks))) {
                        logger.error("delegate was not suitable for wrapping or just unneeded, let it go");
                }
                return wrapped;
        }
        public final Factory getFactory() {
                return this.factory;
        }
        public final O getOperational() {
                return this.operational;
        }

}
