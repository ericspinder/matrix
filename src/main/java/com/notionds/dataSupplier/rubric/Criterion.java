package com.notionds.dataSupplier.rubric;

import dev.inward.matrix.crud.Container;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.provider.Parent;
import dev.inward.matrix.crud.Support;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Envoy;

import static com.notionds.dataSupplier.rubric.Predictor.*;

public abstract class Criterion<D extends Datum<D,FP,OP,IP,XP,E,T,PRE>,FP extends Fact<FP,OP,IP,XP,BP,A,?,?,?,?,?,?>,OP extends Operational<FP,OP,IP,XP>,IP extends Id<IP,XP>,XP extends Context<XP>,BP extends Bus<FP,IP,XP,BP>,E extends Envoy<D,FP,OP,IP,XP,E>,A extends Parent<FP,A,?,?,?,?,?>,T extends Criterion<D,FP,OP,IP,XP,BP,E,A,T,PRE>,PRE extends Predictor<D,FP,OP,IP,XP,BP,E,A,T,PRE>> {

    // on method
    // on phase
    // on time
    // on garbage
    // on countdown
    // on shutdown
    public static final class OnPhase<D extends Datum<D,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Criterion<D,C,F,O,S,I,X,OnPhase<D,C,F,O,S,I,X>,Phase<D,C,F,O,S,I,X>> {


        @Override
        public void enroll(Phase<D, C, F, O, S, I, X> predictor, Envoy<D, C, F, O, S, I, X> envoy) {

        }
    }
    public static final class OnShutdown<D extends Datum<D,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Criterion<D,C,F,O,S,I,X,OnShutdown<D,C,F,O,S,I,X>,Shutdown<D,C,F,O,S,I,X>> {

        @Override
        public void enroll(Shutdown<D, C, F, O, S, I, X> predictor, Envoy<D, C, F, O, S, I, X> envoy) {

        }
    }
    public static class OnMethod<D extends Datum<D,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Criterion<D,C,F,O,S,I,X,OnMethod<D,C,F,O,S,I,X>,Method<D,C,F,O,S,I,X>> {
        public void doMethod() {

        }

        @Override
        public void enroll(Method<D, C, F, O, S, I, X> predictor, Envoy<D, C, F, O, S, I, X> envoy) {

        }
    }
    public static class OnGarbage<D extends Datum<D,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>, O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Criterion<D,C,F,O,S,I,X,OnGarbage<D,C,F,O,S,I,X>,Garbage<D,C,F,O,S,I,X>> {

        @Override
        public void enroll(Garbage<D, C, F, O, S, I, X> predictor, Envoy<D, C, F, O, S, I, X> envoy) {

        }
    }
    public static class OnTime<D extends Datum<D,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>, O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Criterion<D,C,F,O,S,I,X,OnTime<D,C,F,O,S,I,X>,Time<D,C,F,O,S,I,X>> {

        @Override
        public void enroll(Time<D, C, F, O, S, I, X> predictor, Envoy<D, C, F, O, S, I, X> envoy) {

        }
    }
    public static class OnCountdown<D extends Datum<D,D,C,F,O,S,I,X>,C extends Container<D,C,F,O,S,I,X>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> extends Criterion<D,C,F,O,S,I,X,OnCountdown<D,C,F,O,S,I,X>,Countdown<D,C,F,O,S,I,X>> {

        @Override
        public void enroll(Countdown<D, C, F, O, S, I, X> predictor, Envoy<D, C, F, O, S, I, X> envoy) {

        }
    }

    public Criterion() {

    }
    public abstract void enroll(PRE predictor, Envoy<D,C,F,O,S,I,X> envoy);


}
