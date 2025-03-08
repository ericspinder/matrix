/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public interface MatrixItem<PATH extends Comparable<PATH>,K extends MatrixKey<PATH,K,I>,I extends MatrixItem<PATH,K,I>> extends Comparable<I> {

    K getKey();

    default int compareTo(I that) {
        return this.getKey().compareTo(that.getKey());
    }
}
