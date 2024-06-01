package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.resources.Contrivance;

import java.io.IOException;
import java.nio.file.*;

public abstract class Librarian<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> implements Watchable, Comparable<Librarian<S,L,PATH,ID,T,C>> {

    protected final L library;
    protected Contrivance<S,L,PATH,ID,T,C,?,?> contrivance;

    public Librarian(L library, Contrivance<S,L,PATH,ID,T,C,?,?> contrivance) {
        this.library = library;
        this.contrivance = contrivance;
    }
    public static class DNS extends Librarian<DNS, Domain, Library.DNS,?,DNS> {

        @Override
        public <M extends Matter<DNS, Domain, M>, COMP extends Complication<DNS, Domain>> boolean registerComplication(COMP complication) {
            return false;
        }

        @Override
        <ID extends Comparable<ID>, T extends Concept.Tangible<DNS, Domain, Library.DNS, ID, T, C>, C extends Concept<DNS, Domain, Library.DNS, ID, T, C>, CRIT extends Criterion, P extends Predictable<DNS, Domain, Library.DNS, ID, T, C, CRIT, P, COMP>, COMP extends Complication<DNS, Domain, Library.DNS, ID, T, C, CRIT, P, COMP>> void autoSettle(COMP complication) {

        }

        @Override
        public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
            return null;
        }

        @Override
        public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
            return null;
        }
    }
    public abstract <M extends Matter<S,L,M>,COMP extends Complication<S,L,>> boolean registerComplication(COMP complication);

    abstract <ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CRIT extends Criterion,P extends Predictable<S,L,PATH,ID,T,C,CRIT,P,COMP>,COMP extends Complication<S,L,PATH,ID,T,C,CRIT,P,COMP>> void autoSettle(COMP complication);

    @Override
    public WatchKey register(WatchService watcher, WatchEvent<?> events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    public L getLibrary() {
        return library;
    }

    public char getInitSigil() {
        return initSigil;
    }

    public Range<PATH> getRange() {
        return range;
    }

    @Override
    public int compareTo(B that) {
        return 0;
    }
}
