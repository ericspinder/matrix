/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;

public class FactKey<F extends Fact<F,K,V,M,R,L>,K extends FactKey<F,K,V,M,R,L>,V extends FactView<F,K,V,M,R,L>,M extends FactModel<F,K,V,M,R,L>,R extends FactReference<F,K,V,M,R,L>,L extends FactLibrarian<F,K,V,M,R,L>> extends AddressedKey<F,String,K,V,M,R,L,HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel, HttpDirectoryReference, HttpDirectoryLibrarian,String> {
    protected FactKey(URI uri, String s, HttpDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }


    public abstract static class Builder<F extends Fact<F,K,V,M,R,L>,K extends FactKey<F,K,V,M,R,L>,V extends FactView<F,K,V,M,R,L>,M extends FactModel<F,K,V,M,R,L>,R extends FactReference<F,K,V,M,R,L>,L extends FactLibrarian<F,K,V,M,R,L>> extends AddressedKey.Builder<F,String,K,V,M,R,L,HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel, HttpDirectoryReference, HttpDirectoryLibrarian,String> {

    }
}
