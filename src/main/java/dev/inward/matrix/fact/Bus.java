package dev.inward.matrix.fact;

import dev.inward.matrix.Context;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.Range;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Envoy;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Bus<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,F extends Fact<S,L,PATH,F,N>,N extends Notion<N>> {

        protected final UUID uuid = UUID.randomUUID();
        protected ConcurrentLinkedDeque<Representative<S,L,PATH,F>> deque;

        public Bus(Range<PATH> range) {

        }

        public <DATUM, E extends Envoy<DATUM>> E add(Passenger<DATUM> passenger) {
                E envoy = new Envoy<DATUM>(passenger,((Context)passenger.getClass().getProtectionDomain()).getLibrary().getCatalog().register(passenger);
        }

        /**
         * A map of the Complications currently affecting the bus, the value is the instant they were added
         */
        protected Map<Complication<?,?,S,L,PATH,F,?,?,?>, Instant> complications = new ConcurrentHashMap<>();


        public final void register(R representative) {

        }

        public final M calling() {

                return null;
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


