package dev.inward.matrix.personality;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Notion;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;

import java.time.Instant;

public abstract class Monitor<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,N extends Notion<S,L,PATH,N>,M extends Matter<S,L,PATH,N,M>> {

    protected final Indicia<S,L,PATH,N> indicia;
    protected final Instant createTime = Instant.now();

    protected Monitor(Indicia<S,N,PATH,N> indicia) {
        this.indicia = indicia;
    }

    protected abstract Indicia<S,N,PATH,N> operate(String item, ITEM oldItem);
}
