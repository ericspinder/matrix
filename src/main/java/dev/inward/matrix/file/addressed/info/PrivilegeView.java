/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.addressed.AddressedView;

import java.util.Map;

public class PrivilegeView<K extends PrivilegeKey<K,F,R,A,RESOURCE,M>,F extends Privilege<K,F,R,A,RESOURCE,M>,R extends PrivilegeReference<K,F,R,A,RESOURCE,M>,A extends PrivilegeView<K,F,R,A,RESOURCE,M>,RESOURCE extends PrivilegeResource<K,F,R,A,RESOURCE,M>,M extends PrivilegeModel<K,F,R,A,RESOURCE,M>> extends AddressedView<InfoScheme,InfoLibraryKey,InfoLibrary,InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference, InfoDirectoryView,InfoDirectoryResource,InfoDirectoryModel,String,K,F,R,A,RESOURCE,M> {
    public PrivilegeView(Map<String, Model.InstanceValue> properties, long fileSize) {
        super(properties, fileSize);
    }
}
