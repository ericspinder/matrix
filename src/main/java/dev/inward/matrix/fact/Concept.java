package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.Domain;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.Policy;

import java.io.IOException;
import java.nio.file.*;
import java.util.function.Function;

public abstract class Concept<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C,R>,C extends Concept<PATH,P,ID,T,C,R>,R extends Rider<PATH,P,ID,T,C,R>> implements Addressed<PATH,P,ID,T,C>  {

    protected final T identity;

    public Concept(T identity) {
        this.identity = identity;
    }

    public final T getIdentity() {
        return this.identity;
    }

    public <CRIT extends Criterion<PATH,P,ID,T,C,R>,PREDICT extends Predictable<PATH,P,ID,T,C,R,CRIT,P,COMP,M,OCCURRENCE>,COMP extends Complication<PATH,P,ID,T,C,R,CRIT,P,COMP,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> COMP register(P watcher, Indicia[] indicia, CRIT... criterion) throws IOException {
        return null;
    }

    public abstract static class Tangible<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Tangible<PATH,P,ID,T,C,R>,C extends Concept<PATH,P,ID,T,C,R>,R extends Rider<PATH,P,ID,T,C,R>> implements Addressed.Identity<PATH,P,ID,T,C> {

        protected final ID id;
        protected final P pathway;
        private R rider;
        public Tangible(ID id, P pathway) {
            this.id = id;
            this.pathway = pathway;
        }

        @Override
        public ID getId() {
            return id;
        }

        @Override
        public PATH getPath() {
            return pathway.getPath();
        }

        @Override
        public C get() {
            return rider.get();
        }

        @SuppressWarnings("unchecked")
        public Context<PATH,P,ID,T,C,R> getContext() {
            return ((Context<PATH,P,ID,T,C,R>)this.id.getClass().getProtectionDomain());
        }
        public Catalog<S,L,PATH,ID,T,C,?> getCatalog() {
            return this.getContext().getCatalog();
        }

        @Override
        public Domain getDomain() {
            return this.getCatalog().getLibrary().getDomain();
        }

        @Override
        public S getScheme() {
            return this.getCatalog().getLibrary().get_Scheme();
        }

        @Override
        public P getPathway() {
            return ((Factory<S,L,PATH,ID,T,C>)this.getContext().getClassLoader()).getGathering().getPathway();
        }

        public Terrene getTerrene() {
            return this.getCatalog().getLibrary().getTerrene();
        }

        @Override
        public Complication<S,L,PATH,ID,T,C,?,?,?,?,?> register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
            return null;
        }

        @Override
        public Complication<S,L,PATH,ID,T,C,?,?,?,?,?> register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
            return null;
        }
    }

    public static class Resource<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>> extends dev.inward.matrix.Resource<C> {

        public Resource(String className, Policy<? extends Function<C,?>,C,P,ID,T,C,CAT,?,?,?,?,?>[] policies, long warnOnTotal, long hardLimit, Range<P> range) {
            super(className, policies, warnOnTotal, hardLimit);
        }

    }
}
