/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.Terrene;

public class HttpScheme extends Scheme<HttpScheme,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference,HttpLibraryLibrarian,String,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference,HttpDirectoryLibrarian> {

    public static final HttpScheme EARTH_SCHEME_OF_HTTP = new HttpScheme(Terrene.Earth);
    public static final HttpScheme LUNA_SCHEME_OF_HTTP = new HttpScheme(Terrene.Luna);
    public static final HttpScheme MARS_SCHEME_OF_HTTP = new HttpScheme(Terrene.Mars);
    public static final HttpScheme CHAOSNET_SCHEME_OF_HTTP = new HttpScheme(Terrene.Chaosnet);


    protected HttpScheme(Terrene terrene, MatrixURLStreamHandlerProvider.Protocol protocol) {
        super(terrene, protocol);
    }
    protected HttpScheme(Terrene terrene) {
        this(terrene, MatrixURLStreamHandlerProvider.Protocol.HTTP);
    }

    @Override
    public int compareTo(HttpScheme o) {
        return 0;
    }

}
