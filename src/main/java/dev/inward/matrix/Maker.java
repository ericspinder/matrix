package dev.inward.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Promise;

public abstract class Maker<I extends Identity<I,X>,X extends Context<X>,MAT extends Maker<I,X,MAT>> extends Matter<I,X,MAT> {

    @Unspoken
    private final ;
    public Maker(I id, C container, K keeper) {
        super(id,container);
        this.keeper = keeper;
    }

    abstract boolean validate(Promise<?,D,?> promise);


}
