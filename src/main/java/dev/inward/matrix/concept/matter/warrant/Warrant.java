package dev.inward.matrix.concept.matter.warrant;

import dev.inward.crud.Container;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.phenomenon.producer.promise.Promise;

public abstract class Warrant<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Identity.Path<D,O,C,X>> extends Promise<D,O,C,X, Identity.Gate> {

    private final Identity.Gate creator;
    public Warrant(X context, C container, Identity.Gate ego) {
        super(context, container, superEgo);
    }
}
