/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.AddressedModel;

public class PrivilegeModel<K extends PrivilegeKey<K,F,V,M,R,B>,F extends Privilege<K,F,V,M,R,B>,V extends PrivilegeView<K,F,V,M,R,B>,M extends PrivilegeModel<K,F,V,M,R,B>,R extends PrivilegeReference<K,F,V,M,R,B>,B extends PrivilegeLibrarian<K,F,V,M,R,B>> extends AddressedModel<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian,String,K,F,V,M,R,B> {
    public PrivilegeModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
