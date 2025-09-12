/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public interface MatrixItem<K extends MatrixKey<K,I,V,M,R,B>,I extends MatrixItem<K,I,V,M,R,B>,V extends View<I,V,M,R,B>,M extends Model<I>,R extends _WeakReference<I,V,M,R,B>, B extends Concept<I,V,M,R,B>> extends Comparable<I> {

    K getKey();

    default int compareTo(I that) {
        return this.getKey().compareTo(that.getKey());
    }
}
