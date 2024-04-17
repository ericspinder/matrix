package dev.inward.matrix.fact;

import crud.Protocol;
import crud.Volume;
import dev.inward.matrix.Provider;
import dev.inward.matrix.*;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.authoritative.notion.concept.*;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.phenomenon.producer.ExecutionExceptionly;
import dev.inward.matrix.phenomenon.producer.InterruptionExceptionally;
import dev.inward.matrix.phenomenon.producer.TimeoutExceptionally;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.WatchService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static dev.inward.matrix.fact.Criterion.*;

public abstract class Predictable<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CRIT extends Criterion,P extends Predictable<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,COMP extends Complication<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,M extends Matter<S,L,M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> implements WatchService {

    protected final Catalog<S,L,PATH,ID,T,C,?> catalog;
    protected final Map<COMP,M[]> complicationResultsCacheMapping = new ConcurrentHashMap<>();

    public Predictable(Catalog<S,L,PATH,ID,T,C,?> catalog) {
        this.catalog = catalog;
    }
    /**
     *
     * @param criterion Parameters to create the Complication
     * @param provider How the complication will retrieve the concept
     * @return the Complication that has been created
     */
    @SuppressWarnings("unchecked")
    public COMP register(CRIT criterion, Provider<S,L,PATH,ID,T,C> provider) {
        COMP complication = this.createComplication((P)this,criterion,provider);
        if (complication.isValid()) {

        }
        else {
            return null;
        }

    }
    protected abstract COMP createComplication(P predictable, CRIT criteria, Provider<S,L,PATH,ID,T,C> provider);

    @Override
    public COMP poll() {
        return null;
    }

    public Catalog<S, L, PATH, ID, T, C, ?> getCatalog() {
        return catalog;
    }

    @SuppressWarnings("unchecked")
    public Class<C> getConceptClass() {
        return ((Class<C>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
    }

    /**
     *
     */
    public abstract Matter<S,L,?,?> complete(C concept) throws ExecutionExceptionly, InterruptionExceptionally, TimeoutExceptionally;

    public static class Limited<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Predictable<S,L,PATH,ID,T,C,Criterion.Limiter,Predictable.Limited<S,L,PATH,ID,T,C>, Complication.Limitation<S,L,PATH,ID,T,C>> {

        public Limited(Catalog<S,L,PATH,ID,T,C,?> catalog) {
            super(catalog);
        }

        @Override
        public Complication.Limitation<S,L,PATH,ID,T,C> createComplication(Limited<S,L,PATH,ID,T,C> limited, Limiter limiter, Provider<S,L,PATH,ID,T,C> provider) {
            return new Complication.Limitation<>(this,limiter, provider);
        }


        @Override
        public Boolean complete() throws ExecutionExceptionly, InterruptionExceptionally, TimeoutExceptionally {
            return null;
        }

    }
    public final static class Handled<S extends Scheme<S,L>,L extends Library<S,L>,PATHWAY extends Pathway<?>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATHWAY,ID,T,C>,C extends Concept<S,L,PATHWAY,ID,T,C>> {


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

-        @Override
        public int compareTo(Time<Y, DATUM, D, E, F, O, I, X, B, P, FAB, C, T, V, M> o) {
            return 0;
        }
    }
    public final static class Downer<DATUM,S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,F extends Fact<S,L,PATH,F>,CRIT extends Criterion,P extends Predictable<DATUM,S,L,PATH,F,CRIT,P>>extends Predictable<DATUM,S,L,PATH,F,CRIT,OnCountdown<DATUM,F,I,X>,Downer<Y,DATUM,D,E,F,O,I,X,B,P,FAB,C,T,V,M>> {

    }

    @Override
    public void close() throws IOException {

    }

}
