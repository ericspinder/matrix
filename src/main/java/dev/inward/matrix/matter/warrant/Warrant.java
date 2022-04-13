package dev.inward.matrix.matter.warrant;

import dev.inward.crud.Container;
import dev.inward.matrix.matter.Promise;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.path.Path;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.Operational;

public abstract class Warrant<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Path<D,O,C,X>> extends Promise<D,O,C,X, Identity.SuperEgo> {

    private final Identity.SuperEgo creator;
    public Warrant(X context, C container, Identity.SuperEgo ego) {
        super(context, container, superEgo);
    }
}
