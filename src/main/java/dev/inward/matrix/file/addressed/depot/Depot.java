/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.Addressed;

public abstract class Depot<K extends DepotKey<K,F,R,A,RESOURCE,M>,F extends Depot<K,F,R,A,RESOURCE,M>,R extends DepotReference<K,F,R,A,RESOURCE,M>,A extends DepotAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends DepotResource<K,F,R,A,RESOURCE,M>,M extends DepotModel<K,F,R,A,RESOURCE,M>> extends Addressed<DepotScheme,DepotLibraryKey,DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference,DepotDirectoryAttributes,DepotDirectoryResource,DepotDirectoryModel,String,K,F,R,A,RESOURCE,M> {


    public Depot(K identity) {
        super(identity);
    }



}
