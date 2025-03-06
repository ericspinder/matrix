/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.AddressedModel;

public class PrivilegeModel<K extends PrivilegeKey<K,F,R,A,RESOURCE,M>,F extends Privilege<K,F,R,A,RESOURCE,M>,R extends PrivilegeReference<K,F,R,A,RESOURCE,M>,A extends PrivilegeAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends PrivilegeResource<K,F,R,A,RESOURCE,M>,M extends PrivilegeModel<K,F,R,A,RESOURCE,M>> extends AddressedModel<InfoScheme,InfoLibraryKey,InfoLibrary,InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference,InfoDirectoryAttributes,InfoDirectoryResource,InfoDirectoryModel,String,K,F,R,A,RESOURCE,M> {
    public PrivilegeModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }
}
