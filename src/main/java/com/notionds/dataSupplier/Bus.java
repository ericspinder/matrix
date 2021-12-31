package com.notionds.dataSupplier;

import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;
import com.notionds.dataSupplier.task.Proffer;
import com.notionds.dataSupplier.task.Task;
import com.notionds.dataSupplier.provider.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public class Bus<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O,D>, C extends Container<DATUM,O,C,D,B>,D extends Datum<DATUM,O,C,D,B>,B extends Bus<DATUM,O,C,D,B,A,P,M>, A extends Advisor<DATUM,O,C,D,B,?>,P extends Provider<DATUM,O,C,D,B>,M extends Meta<DATUM,O,C,D,B>> {

        private static final Logger logger = LogManager.getLogger();
        protected transient A advisor;
        protected final N notion;
        private final UUID uuid;
        protected final O operational;
        protected P provider;
        protected M meta;
        private final StampedLock memberGate = new StampedLock();

        public Bus(final UUID uuid, final A advisor, final O operational, final N notion, final P provider, final M meta)  {
                this.uuid = uuid;
                this.operational = operational;
                this.notion = notion;
                this.provider = provider;
                this.advisor = advisor;
                this.meta = meta;
        }

        @SuppressWarnings("unchecked")
        public DATUM take(Proffer proffer, Task[] tasks, boolean isWriteLock) {
                long lock;
                if(!isWriteLock) lock = memberGate.readLock();
                else lock = memberGate.writeLock();
                try {
                        N wrapped = this.provider.getWrappedReady();
                        if (wrapped.getContainer().checkout(advisor.add(wrapped,tasks))) {
                                return (DATUM) wrapped;
                        }
                        return null;
                }
                finally {
                        if(isWriteLock) memberGate.unlockWrite(lock);
                        memberGate.unlockRead(lock);
                }
        }

        public Promise<DATUM> get(Task[] tasks, boolean isWriteLock) {
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
        public DATUM get(Promise<DATUM> promise) {
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
         * @param DATUM the delegate
         * @param args an array of Objects for the constructor, Strings may sometimes be assumed by default, they should match the forth and such constructor parameters
         * @param tasks the tasks to be associated with this notion. Cleanup instructions
         * @return The wrapped delegate, but it might be closed, check to see if Situation.Open before use, unless you're feeling lucky or irrelevant.
         */
        @SuppressWarnings("unchecked")
        public N wrap(DATUM DATUM, Object[] args, Task[] tasks) {
                C container = (C) notionSupplier.getNewContainer(operational);
                N wrapped = notion.wrapNotion(container, DATUM, args);
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
