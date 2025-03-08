/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.addressed.Addressed;

import java.security.Principal;

public abstract class Privilege<K extends PrivilegeKey<K,F,R,A,RESOURCE,M>,F extends Privilege<K,F,R,A,RESOURCE,M>,R extends PrivilegeReference<K,F,R,A,RESOURCE,M>,A extends PrivilegeAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends PrivilegeResource<K,F,R,A,RESOURCE,M>,M extends PrivilegeModel<K,F,R,A,RESOURCE,M>> extends Addressed<InfoScheme,InfoLibraryKey,InfoLibrary,InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference,InfoDirectoryAttributes,InfoDirectoryResource,InfoDirectoryModel,String,K,F,R,A,RESOURCE,M> implements Principal {


    public Privilege(K key) {
        super(key);
    }


    @Override
    public String getName() {
        return key.getId();
    }

}
