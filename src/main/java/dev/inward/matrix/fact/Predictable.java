package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.authoritative.notion.concept.*;
import dev.inward.matrix.phenomenon.producer.ExecutionExceptionly;
import dev.inward.matrix.phenomenon.producer.InterruptionExceptionally;
import dev.inward.matrix.phenomenon.producer.TimeoutExceptionally;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static dev.inward.matrix.fact.Criterion.*;

public abstract class Predictable<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CRIT extends Criterion,P extends Predictable<S,L,PATH,ID,T,C,CRIT,P,COMP>,COMP extends Complication<S,L,PATH,ID,T,C,CRIT,P,COMP>> implements WatchService {

    p
    /**
     *
     * @param criterion
     * @return the CallSite to be registered
     */
    public abstract COMP registerCriterion(CRIT criterion,C concept);

    /**
     *
     */
    public abstract <E extends Envoy<DATUM,S,L,PATH,ID,I,C,N>> Boolean complete(E envoy) throws ExecutionExceptionly, InterruptionExceptionally, TimeoutExceptionally;

    public static class Limited<DATUM,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<S,L,PATH,ID,I,C>,C extends Concept<S,L,PATH,ID,I,C,N>,N extends Notion<S,L,PATH,N>,O extends Operational<F,ID,I,X,O>,B extends Bus<F,ID,I,X,R,O,B>> extends Predictable<F,ID,I,X,R,O,B,Limiter,Limited<F,ID,I,X,R,O,B>> {


        @Override
        public <C extends CallSite> C registerCriterion(Limiter criterion) {
            return null;
        }

    }
    public final static class Handled<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Protocol<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Construct<FAB,C,T,V,M>> extends Predictable<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M,Wrapped<DATUM,F,I,X>,Handled<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {


        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Wrapped<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Handled<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }

    public final static class Time<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,T,V,M>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,T,V,M>,C extends Protocol<C,M>,T extends Effect<FAB,C,T,V,M>,V extends Volume<FAB,C,T,V,M>,M extends Construct<FAB,C,T,V,M>> extends Predictable<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M, Timed<DATUM,F,I,X>,Time<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

        @Override
        public <COMP extends Complication<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M, COMP>> COMP registerCriterion(Timed<DATUM, F, I, X> criterion) {
            return null;
        }

        @Override
        public int compareTo(Time<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
    public final static class Downer<DATUM,S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,F extends Fact<S,L,PATH,F>,CRIT extends Criterion,P extends Predictable<DATUM,S,L,PATH,F,CRIT,P>>extends Predictable<DATUM,S,L,PATH,F,CRIT,OnCountdown<DATUM,F,I,X>,Downer<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public  poll() {
        return null;
    }

    @Override
    public Clerk<?,?,S,L,PATH,?> poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public Clerk<?,?,S,L,PATH,?> take() throws InterruptedException {
        return null;
    }
}
