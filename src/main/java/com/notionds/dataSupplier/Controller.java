package com.notionds.dataSupplier;

import com.notionds.dataSupplier.cron.Cron;
import com.notionds.dataSupplier.delegation.Delegation;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.exceptions.Advice;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.operational.task.Proffer;
import com.notionds.dataSupplier.operational.task.Task;
import com.notionds.dataSupplier.provider.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.concurrent.locks.StampedLock;

public class Controller<N, O extends Operational<N,W,T>, W extends Wrapper<N,O,T>, T extends Container<N,O,W>, S extends NotionSupplier<N,O,W,T,A,D,C,L>, A extends Advice<N,O,W>, D extends Delegation<N,O,W,T>, C extends Cron<N,O,W,T>, P extends Provider<N,O,W,T>, L extends NotionClassLoader<N,O,W,T,A,D,C>> {

        private static final Logger logger = LogManager.getLogger();
        private final Factory factory;
        protected final S notionSupplier;
        protected final O operational;
        protected final A advice;
        protected final D delegation;
        protected P provider;
        protected final C cron;
        private final StampedLock memberGate = new StampedLock();

        public Controller(final O operational, final A advice, final D delegation, final C cron, final P provider, final S notionSupplier, final Factory<?> factory) {
                this.operational = operational;
                this.advice = advice;
                this.delegation = delegation;
                this.provider = provider;
                this.cron = cron;
                this.notionSupplier = notionSupplier;
                this.factory = factory;
        }

        @SuppressWarnings("unchecked")
        public N take(Proffer proffer, Task[] tasks, boolean isWriteLock) {
                long lock;
                if(!isWriteLock) lock = memberGate.readLock();
                else lock = memberGate.writeLock();
                try {
                        W wrapped = this.provider.getWrappedReady();
                        if (wrapped.getContainer().checkout(cron.add(wrapped,tasks))) {
                                return (N) wrapped;
                        }
                        return null;
                }
                finally {
                        if(isWriteLock) memberGate.unlockWrite(lock);
                        memberGate.unlockRead(lock);
                }
        }

        public Promise<N> get(Task[] tasks, boolean isWriteLock) {
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
        public N get(Promise<N> promise) {
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
         * @param delegate the delegate
         * @param args an array of Objects for the constructor, Strings may sometimes be assumed by default, they should match the forth and such constructor parameters
         * @param tasks the tasks to be associated with this notion. Cleanup instructions
         * @return The wrapped delegate, but it might be closed, check to see if Situation.Open before use, unless you're feeling lucky or irrelevant.
         */
        @SuppressWarnings("unchecked")
        public W wrap(N delegate, Object[] args, Task[] tasks) {
                T container = (T) notionSupplier.getNewContainer(operational);
                W wrapped = delegation.getDelegate(container, delegate, args);
                if (!wrapped.getContainer().checkout(cron.add(wrapped, tasks))) {
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

        public Collection<W> getDrain() {
                return this.drain;
        }

}
