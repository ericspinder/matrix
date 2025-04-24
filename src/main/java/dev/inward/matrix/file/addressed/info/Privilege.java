/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.addressed.Addressed;

import java.security.Principal;

public abstract class Privilege<K extends PrivilegeKey<K,F,V,M,R,B>,F extends Privilege<K,F,V,M,R,B>,V extends PrivilegeView<K,F,V,M,R,B>,M extends PrivilegeModel<K,F,V,M,R,B>,R extends PrivilegeReference<K,F,V,M,R,B>,B extends PrivilegeLibrarian<K,F,V,M,R,B>> extends Addressed<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian,String,K,F,V,M,R,B> implements Principal {


    public Privilege(K key) {
        super(key);
    }


    @Override
    public String getName() {
        return key.getId();
    }

}
