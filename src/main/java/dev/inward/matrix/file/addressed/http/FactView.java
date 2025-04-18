/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.http;

import dev.inward.matrix.file.addressed.AddressedView;

public class FactView<LB extends FactLibrarian<LB,K,F,V,M,R,G>,K extends FactKey<LB,K,F,V,M,R,G>,F extends Fact<LB,K,F,V,M,R,G>,V extends FactView<LB,K,F,V,M,R,G>,M extends FactModel<LB,K,F,V,M,R,G>,R extends FactReference<LB,K,F,V,M,R,G>,G extends FactSteward<LB,K,F,V,M,R,G>> extends AddressedView<HttpScheme,HttpLibraryKey,HttpLibrary,HttpLibraryView,HttpLibraryModel,HttpLibraryReference, HttpLibraryLibrarian,String,HttpCatalogKey,HttpCatalog,HttpCatalogView,HttpCatalogModel,HttpCatalogReference, HttpCatalogLibrarian,HttpDirectoryLibrarian,HttpDirectoryKey,HttpDirectory,HttpDirectoryView,HttpDirectoryModel,HttpDirectoryReference, HttpDirectoryLibrarian,LB,String,K,F,V,M,R,G> {
    public FactView(F fact, M factModel) {
        super("FactView", fact, factModel);
    }
}
