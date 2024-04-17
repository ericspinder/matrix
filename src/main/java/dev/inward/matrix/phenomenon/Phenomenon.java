package dev.inward.matrix.phenomenon;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.concept.matter.Matter;

import java.util.concurrent.Callable;

public class Phenomenon<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,F extends Fact<S,L,PATH,F>,O extends Model<S,L,PATH,F,O>,M extends Matter<S,L,PATH,M>> implements Callable<M> {

    protected final Identity.Query query;
    protected final O model;
    protected final Bus<S,L,PATH,F> bus;

    protected Phenomenon(O model,Bus<S,L,PATH,F> bus) {
        this.model = model;
        this.bus = bus;
    }

    @SuppressWarnings("unchecked")
    public M call() {
        return model.doit((P)this);
    }

}
