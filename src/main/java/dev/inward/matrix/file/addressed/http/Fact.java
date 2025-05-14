/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.Addressed;

public class Fact<F extends Fact<F,K,V,M,R,L>,K extends FactKey<F,K,V,M,R,L>,V extends FactView<F,K,V,M,R,L>,M extends FactModel<F,K,V,M,R,L>,R extends FactReference<F,K,V,M,R,L>,L extends FactLibrarian<F,K,V,M,R,L>> extends Addressed<F,String,K,V,M,R,L,HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference,HttpDirectoryLibrarian,String> {

    public Fact(K key) {
        super(key);
    }
}
