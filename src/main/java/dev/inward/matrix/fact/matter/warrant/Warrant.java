package dev.inward.matrix.fact.matter.warrant;

import dev.inward.crud.Container;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.phenomenon.producer.promise.Promise;

public abstract class Warrant<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Identity.Path<D,O,C,X>> extends Promise<D,O,C,X, Identity.SuperEgo> {

    private final Identity.SuperEgo creator;
    public Warrant(X context, C container, Identity.SuperEgo ego) {
        super(context, container, superEgo);
    }
}
