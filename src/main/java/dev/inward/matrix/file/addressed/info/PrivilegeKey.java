/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;

public class PrivilegeKey<LB extends PrivilegeLibrarian<LB,K,F,V,M,R,G>, K extends PrivilegeKey<LB,K,F,V,M,R,G>,F extends Privilege<LB,K,F,V,M,R,G>,V extends PrivilegeView<LB,K,F,V,M,R,G>,M extends PrivilegeModel<LB,K,F,V,M,R,G>,R extends PrivilegeReference<LB,K,F,V,M,R,G>,G extends PrivilegeSteward<LB,K,F,V,M,R,G>> extends AddressedKey<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibrarySteward,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogSteward,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectorySteward,LB,String,K,F,V,M,R,G> {


    protected PrivilegeKey(URI uri, String s, InfoDirectoryKey directoryKey) {
        super(uri, s, directoryKey);
    }

    public static abstract class Builder<LB extends PrivilegeLibrarian<LB,K,F,V,M,R,G>, K extends PrivilegeKey<LB,K,F,V,M,R,G>,F extends Privilege<LB,K,F,V,M,R,G>,V extends PrivilegeView<LB,K,F,V,M,R,G>,M extends PrivilegeModel<LB,K,F,V,M,R,G>,R extends PrivilegeReference<LB,K,F,V,M,R,G>,G extends PrivilegeSteward<LB,K,F,V,M,R,G>> extends AddressedKey.Builder<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibrarySteward,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogSteward,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectorySteward,LB,String,K,F,V,M,R,G> {

    }
}
