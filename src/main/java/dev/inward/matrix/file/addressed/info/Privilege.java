/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.addressed.Addressed;

import java.security.Principal;

public abstract class Privilege<LB extends PrivilegeLibrarian<LB,K,F,V,M,R,G>, K extends PrivilegeKey<LB,K,F,V,M,R,G>,F extends Privilege<LB,K,F,V,M,R,G>,V extends PrivilegeView<LB,K,F,V,M,R,G>,M extends PrivilegeModel<LB,K,F,V,M,R,G>,R extends PrivilegeReference<LB,K,F,V,M,R,G>,G extends PrivilegeSteward<LB,K,F,V,M,R,G>> extends Addressed<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibrarySteward,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogSteward,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectorySteward,LB,String,K,F,V,M,R,G> implements Principal {


    public Privilege(K key) {
        super(key);
    }


    @Override
    public String getName() {
        return key.getId();
    }

}
