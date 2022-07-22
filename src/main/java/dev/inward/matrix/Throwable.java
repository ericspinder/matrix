package dev.inward.matrix;

import dev.inward.crud.Container;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.dataSupplier.container.Phase;
import dev.inward.matrix.matter.Topic;
import dev.inward.matrix.matter.sanction.Sanction;
import dev.inward.matrix.operational.Operational;

public class Throwable<D extends Datum<D,O,C,I>,O extends Operational<D,O>, C extends Container<D,O,C,I,?>,I extends Identity<D,I>, S extends Sanction<S,?,?,?,?>, M extends Throwable<D,O,C,I,S,M,T>,T extends java.lang.Throwable> extends Topic<D,O,C,I,S,M> {

    private final T throwable;

    public Throwable(String name, S sanction, Focus focus, Locus locus, T throwable) {
        super(name, sanction,focus,locus,Phase.Manic);
        this.throwable = throwable;
    }

}
