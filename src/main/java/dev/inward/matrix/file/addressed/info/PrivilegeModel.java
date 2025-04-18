/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.AddressedModel;

public class PrivilegeModel<LB extends PrivilegeLibrarian<LB,K,F,V,M,R,G>, K extends PrivilegeKey<LB,K,F,V,M,R,G>,F extends Privilege<LB,K,F,V,M,R,G>,V extends PrivilegeView<LB,K,F,V,M,R,G>,M extends PrivilegeModel<LB,K,F,V,M,R,G>,R extends PrivilegeReference<LB,K,F,V,M,R,G>,G extends PrivilegeSteward<LB,K,F,V,M,R,G>> extends AddressedModel<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibraryLibrarian,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogLibrarian,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectoryLibrarian,LB,String,K,F,V,M,R,G> {
    public PrivilegeModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
