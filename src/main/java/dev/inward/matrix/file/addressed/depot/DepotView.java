/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.addressed.AddressedView;

import java.util.Map;

public class DepotView<K extends DepotKey<K,F,R,A,RESOURCE,M>,F extends Depot<K,F,R,A,RESOURCE,M>,R extends DepotReference<K,F,R,A,RESOURCE,M>,A extends DepotView<K,F,R,A,RESOURCE,M>,RESOURCE extends DepotResource<K,F,R,A,RESOURCE,M>,M extends DepotModel<K,F,R,A,RESOURCE,M>> extends AddressedView<DepotScheme,DepotLibraryKey,DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference, DepotDirectoryView,DepotDirectoryResource,DepotDirectoryModel,String,K,F,R,A,RESOURCE,M> {
    public DepotView(Map<String, Model.InstanceValue> properties, long fileSize) {
        super(properties, fileSize);
    }
}
