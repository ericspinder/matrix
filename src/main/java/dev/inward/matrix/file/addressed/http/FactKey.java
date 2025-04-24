/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;

public class FactKey<K extends FactKey<K,F,V,M,R,B>,F extends Fact<K,F,V,M,R,B>,V extends FactView<K,F,V,M,R,B>,M extends FactModel<K,F,V,M,R,B>,R extends FactReference<K,F,V,M,R,B>,B extends FactLibrarian<K,F,V,M,R,B>> extends AddressedKey<HttpScheme,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference,HttpLibraryLibrarian,String,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference,HttpCatalogLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference, HttpDirectoryLibrarian,String,K,F,V,M,R,B> {
    protected FactKey(URI uri, String s, HttpDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }
}
