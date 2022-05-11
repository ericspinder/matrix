package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Bus<Y extends Factory<Y,F,O,I,X,B,P,NP,PP,C,M>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP,C,M>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP,C,M>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP,C,M>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> {

        protected O operational;
        protected final Map<Criteria<Y,F,O,I,X,B,P,NP,PP>, Criterion<Y,?,F,O,I,X,B,P,NP,PP,?,?,?>[]> criteriaMap;

        public Bus(O operational, Map<Criteria<Y,F,O,I,X,B,P,NP,PP>, Criterion<Y,?,F,O,I,X,B,P,NP,PP,?,?,?>[]>  criteriaMap) {
                this.operational = operational;
                this.criteriaMap = criteriaMap;
        }
        public final O getOperational() {
                return this.operational;
        }
        public final Map<Criteria<Y,F,O,I,X,B,P,NP,PP>, Criterion<Y,?,F,O,I,X,B,P,NP,PP,?,?,?>[]>  getCriteriaMap(){
                return this.criteriaMap;
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

