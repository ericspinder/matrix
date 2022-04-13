package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.sanction.Sanction;
import dev.inward.matrix.matter.warrant.why.Why;
import dev.inward.matrix.operational.Operational;
import org.objectweb.asm.ClassVisitor;

import java.io.Serializable;
import java.lang.invoke.MethodHandle;

import static dev.inward.matrix.rubric.Predictor.*;


public abstract class Criterion<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>,T extends Criterion<Y,D,F,O,I,X,B,P,E,T,PRE>,PRE extends Predictor<Y,D,F,O,I,X,B,P,E,T,PRE>> implements Comparable<T>, Serializable {

    public static class Limiter<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Criterion<Y,D,F,O,I,X,B,P,E,Limiter<Y,D,F,O,I,X,B,P,E>,Limited<Y,D,F,O,I,X,B,P,E>> {

        @Override
        public boolean engage(E envoy, Position position) {
            return false;
        }

        @Override
        public int compareTo(Limiter<Y, D, F, O, I, X, B, P, E> o) {
            return 0;
        }
    }
    public static class Wrapped<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Criterion<Y,D,F,O,I,X,B,P,E, Wrapped<Y,D,F,O,I,X,B,P,E>, Handled<Y,D,F,O,I,X,B,P,E>> {

        protected final MethodHandle handle;

        public Wrapped(MethodHandle handle) {
            this.handle = handle;
        }


        @Override
        public int compareTo(Wrapped<Y, D, F, O, I, X, B, P, E> o) {
            return 0;
        }

        @Override
        public boolean engage(E envoy, Position position) {
            return false;
        }
    }
    public static class Replacement<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>,V extends DatumVisitor<Y,D,F,O,I,X,B,P,E>> extends Criterion<Y,D,F,O,I,X,B,P,E,Replacement<Y,D,F,O,I,X,B,P,E,V>,Visited<Y,D,F,O,I,X,B,P,E,V>> {

        protected final ClassVisitor classVisitor;

        public Replacement(ClassVisitor classVisitor) {
            this.classVisitor = classVisitor;
        }


        @Override
        public int compareTo(Replacement<Y, D, F, O, I, X, B, P, E, V> o) {
            return 0;
        }

        @Override
        public boolean engage(E envoy, Position position) {
            return false;
        }
    }
    public static class Chronological<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Criterion<Y,D,F,O,I,X,B,P,E, Chronological<Y,D,F,O,I,X,B,P,E>,Time<Y,D,F,O,I,X,B,P,E>> {

        @Override
        public int compareTo(Chronological o) {
            return 0;
        }

        @Override
        public boolean engage(E envoy, Position position) {
            return false;
        }
    }
    public static class OnCountdown<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends Criterion<Y,D,F,O,I,X,B,P,E,OnCountdown<Y,D,F,O,I,X,B,P,E>, Downer<Y,D,F,O,I,X,B,P,E>> {


        @Override
        public int compareTo(OnCountdown o) {
            return 0;
        }

        @Override
        public boolean engage(E envoy, Position position) {
            return false;
        }
    }

    public Criterion() {

    }
    public abstract boolean engage(E envoy, Position position);

    public enum Position {
        INIT,BEFORE,AFTER,REJECT,GARBAGE,SHUTDOWN
    }

    @SuppressWarnings("unchecked")
    public D handle(E envoy, Roller roller) {
        (((Y)this.getClass().getClassLoader()).getProgenitor()).getBus().getManagement().handle( roller,envoy);
        return null;
    }

}
