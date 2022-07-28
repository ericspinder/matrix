package dev.inward.matrix.rubric.aggregation;

import dev.inward.matrix.advisor.Advisor;
import dev.inward.matrix.fact.intialized.maker.Advice;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Diplomat;
import dev.inward.matrix.fact.notion.concept.Ledger;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

import java.util.LinkedHashMap;
import java.util.Map;

public class Participants<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X>,F extends Fact<F,I,X>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Diplomat<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>,L extends Ledger<Y,D,F,O,I,X,B,P,E>> extends LinkedHashMap<E,L> {

    @SuppressWarnings("unchecked")
    public Participants(Advisor<Y,D,F,O,I,X,B,P,?> advisor, Advice<Y,D,F,O,I,X,B,P,E,L,?> advice) {
        super(,advice.getLoadFactor((Advice<Y,D,F,O,I,X,B,P,E, Ledger<Y,D,F,O,I,X,B,P,E>,?>) advice),advisor.accessOrder((Advice<Y,D,F,O,I,X,B,P,E, Ledger<Y,D,F,O,I,X,B,P,E>,?>) advice));
        int i = advisor.getMaxSize((Advice<Y,D,F,O,I,X,B,P,E, Ledger<Y,D,F,O,I,X,B,P,E>,?>) advice);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<E,L> eldestCandidate) {
        eldestCandidate.getValue().forRemoval(eldestCandidate.getKey());
            return eldestCandidate.getKey().forRemoval(((L));
    }


//    @Override
//    protected boolean removeEldestEntry(Map.Entry<E, V> eldest) {
//        if (size() > maxSize) {
//            E datum = eldest.getKey();
//            if (datum.get() == null) {
//                return true;
//            }
//            if (eldest.getValue().count(datum) > reaperLine) {
//                if (size() > ++unresolvedNesting) {
//                    reaperLine++;
//                    unresolvedNesting = 0;
//                }
//                this.remove(eldest.getKey());
//                this.put(eldest.getKey(), eldest.getValue());
//            } else {
//                //can remove
//
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int getMaxSize() {
//        return maxSize;
//    }
//
//    public void setMaxSize(int maxSize) {
//        this.maxSize = maxSize;
//    }
//
//    public int getReaperLine() {
//        return reaperLine;
//    }
//
//    public void setReaperLine(int reaperLine) {
//        this.reaperLine = reaperLine;
//    }

}
