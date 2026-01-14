/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.http;

import dev.inward.matrix.concept.fact.addressed.AddressedKey;

import java.net.URI;

public class HttpKey<F extends Http<F,K,V,M,R,L>,K extends HttpKey<F,K,V,M,R,L>,V extends HttpView<F,K,V,M,R,L>,M extends HttpModel<F,K,V,M,R,L>,R extends dev.inward.matrix.Seat,L extends HttpLibrarian<F,K,V,M,R,L>> extends AddressedKey<F,String,K,V,M,R,L,HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel, HttpDirectoryReference, HttpDirectoryLibrarian,String> {
    protected HttpKey(URI uri, String s, HttpDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }


    public abstract static class Builder<F extends Http<F,K,V,M,R,L>,K extends HttpKey<F,K,V,M,R,L>,V extends HttpView<F,K,V,M,R,L>,M extends HttpModel<F,K,V,M,R,L>,R extends dev.inward.matrix.Seat,L extends HttpLibrarian<F,K,V,M,R,L>> extends AddressedKey.Builder<F,String,K,V,M,R,L,HttpDirectory,HttpDirectoryKey,HttpDirectoryView,HttpDirectoryModel, HttpDirectoryReference, HttpDirectoryLibrarian,String> {

    }
}
