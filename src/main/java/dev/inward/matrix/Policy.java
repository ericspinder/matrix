package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Ware;

import java.util.Objects;
import java.util.function.Function;

/**
 * @param <BEHAVIOR> The object created during initialization
 * @param
 * @param <P> This class - allows Comparable<P> to work
 */
public abstract class Policy<BEHAVIOR extends Function<C, OCCURRENCE>,PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> implements Runnable {

    //protected final Bus<DATUM, W,P,ID,T,C,CAT> bus;
    protected final Complication<DATUM,P,ID,T,C,?,?,?,M,OCCURRENCE> complication;
    protected final BEHAVIOR behavior;
    public Policy(BEHAVIOR behavior, Complication<DATUM,P,ID,T,C,?,?,?,M,OCCURRENCE> complication) {
        this.behavior = behavior;
        this.complication = complication;
    }

    public BEHAVIOR getBehavior() {
        return this.behavior;
    }

    @Override
    final public void run() {
        complication.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return this.getClass().getCanonicalName().compareTo(o.getClass().getCanonicalName()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass().getCanonicalName());
    }

}
