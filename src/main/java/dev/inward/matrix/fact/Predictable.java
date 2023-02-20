package dev.inward.matrix.fact;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.authoritative.notion.concept.*;
import dev.inward.matrix.phenomenon.producer.ExecutionExceptionly;
import dev.inward.matrix.phenomenon.producer.InterruptionExceptionally;
import dev.inward.matrix.phenomenon.producer.TimeoutExceptionally;

import java.io.Serializable;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;

import static dev.inward.matrix.fact.Criterion.*;

public abstract class Predictable<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<F,I,ID,X>,B extends Bus<F,I,ID,X,B>,CRIT extends Criterion<CRIT>,PRE extends Predictable<F,I,ID,X,B,CRIT,PRE>> implements Comparable<PRE>, Serializable {

    /**
     *
     * @param criterion
     * @return the required CallSite for
     */
    public abstract <C extends CallSite> C registerCriterion(CRIT criterion) throws ExecutionExceptionly, InterruptionExceptionally,TimeoutExceptionally;

    /**
     *
     */
    public abstract <DATUM,E extends Envoy<DATUM>> Boolean complete(B bus, E envoy) throws ExecutionExceptionly, InterruptionExceptionally, TimeoutExceptionally;

    public static class Limited<DATUM,E extends Envoy<DATUM,E>,F extends Fact<F,I,ID>,I extends Identity<I,X>,ID extends Identity<I,ID,X>,X extends Context<X>,O extends Operational<F,>,B extends Bus<F,I,ID,X,B>> extends Predictable<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Limiter<DATUM,F,I,X>,Limited<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {


    }
    public final static class Handled<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictable<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Wrapped<DATUM,F,I,X>,Handled<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {


        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Wrapped<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Handled<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }

    public final static class Time<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictable<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Chronological<DATUM,F,I,X>,Time<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Chronological<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Time<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
    public final static class Downer<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Concept<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Mortal<FAB,C,T,V,M>> extends Predictable<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,OnCountdown<DATUM,F,I,X>,Downer<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(OnCountdown<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Downer<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
}
