/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public interface MatrixItem<B extends Librarian<B,I,V,M,R,T>,K extends MatrixKey<B,K,I,V,M,R,T>,I extends MatrixItem<B,K,I,V,M,R,T>,V extends View<B,I,V,M,R,T>,M extends Model<I>,R extends Reference<B,I,V,M,R,T>,T extends Steward<B,I,V,M,R,T>> extends Comparable<I> {

    K getKey();

    default int compareTo(I that) {
        return this.getKey().compareTo(that.getKey());
    }
}
