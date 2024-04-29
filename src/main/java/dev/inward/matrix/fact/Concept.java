package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.concept.matter.Indicia;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;
import java.util.function.Consumer;

public abstract class Concept<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> implements Addressed<S,L,PATH,ID,T,C>  {

    protected final T identity;

    public Concept(T identity) {
        this.identity = identity;
    }

    public final T getIdentity() {
        return this.identity;
    }

    public <CRIT extends Criterion,P extends Predictable<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,COMP extends Complication<S,L,PATH,ID,T,C,CRIT,P,COMP,M,OCCURRENCE>,M extends Matter<S,L,M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> COMP register(P watcher, Indicia[] indicia, CRIT... criterion) throws IOException {
        return null;
    }

    public abstract static class Tangible<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Identity<S,L,PATH,ID,T,C> implements Path {

        private Representative<S,L,PATH,ID,T,C> representative;
        public Tangible(ID id) {
            super(id);
        }

        @SuppressWarnings("unchecked")
        public Context<S,L,PATH,ID,T,C,?> getContext() {
            return ((Context<S,L,PATH,ID,T,C,?>)this.id.getClass().getProtectionDomain());
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
        public Pathway<S,L,PATH> getPathway() {
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
}
