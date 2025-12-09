/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact;

import dev.inward.matrix.Context;

public abstract class Fact<F extends Fact<F,K,V,M,O,L,C>,K extends FactKey<F,K,V,M,O,L,C>,V extends FactView<F,K,V,M,O,L,C>,M extends FactModel<F,K,V,M,O,L,C>,O extends Cabin<F,K,V,M,O,L,C>,L extends Librarian<F,K,V,M,O,L,C>,C extends Context<F,K,V,M,O,L,C>>  {

    protected final K key;

    protected Fact(K key) {
        this.key = key;
    }

    public K getKey() {
        return this.key;
    }

}
