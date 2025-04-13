/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public abstract class Librarian<B extends Librarian<B,DATUM,V,M,R, T>,DATUM,V extends View<B,DATUM,V,M,R, T>,M extends Model<DATUM>,R extends Reference<B,DATUM,V,M,R, T>, T extends Steward<B,DATUM,V,M,R, T>> {

    public final T steward;

    protected Librarian(T steward) {
        this.steward = steward;
    }

    public T getSteward() {
        return steward;
    }
}
