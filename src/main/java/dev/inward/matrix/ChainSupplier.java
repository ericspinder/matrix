/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.predictable.Criterion;

import java.util.function.Function;

public abstract class ChainSupplier<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,T> implements Function<T,T> {

    protected final Criterion criterion;
    public ChainSupplier(L library, PATH path, Criterion criterion) {
        this.criterion = initialize(library,path,criterion);
        if (criterion.isAutoStart()) {
            this.start();
        }
    }


    public Criterion getCriterion() {
        return criterion;
    }
    public abstract void start();

    public abstract Criterion initialize(Library<S,L,PATH> library,PATH path, Criterion criterion);

    public abstract T create();

}
