package dev.inward.matrix;

import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.route.Road;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Librarian<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,B extends Librarian<S,L,PATH,B>> implements Watchable, Comparable<B> {

    protected final L library;
    protected final char initSigil;
    protected final Range<PATH> range;

    public Librarian(L library,char initSigil, Range<PATH> range) {
        this.library = library;
        this.initSigil = initSigil;
        this.range = range;
    }

    abstract void autoSettle(Clerk<?,?,S,L,PATH,?> clerk);

    @Override
    public <DATUM,E extends Envoy<DATUM,E,S,L,PATH,ID,T,C>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CRIT extends Criterion,P extends Predictable<DATUM,E,S,L,PATH,ID,T,C,CRIT,P,COMP>,COMP extends Complication<DATUM,E,S,L,PATH,ID,T,C,CRIT,P,COMP>> Clerk register(P watcher, Indicia[] events, CRIT... modifiers) throws IOException {
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
