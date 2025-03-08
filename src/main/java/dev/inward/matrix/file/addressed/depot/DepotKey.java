/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;

public abstract class DepotKey<K extends DepotKey<K,F,R,A,RESOURCE,M>,F extends Depot<K,F,R,A,RESOURCE,M>,R extends DepotReference<K,F,R,A,RESOURCE,M>,A extends DepotAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends DepotResource<K,F,R,A,RESOURCE,M>,M extends DepotModel<K,F,R,A,RESOURCE,M>> extends AddressedKey<DepotScheme, DepotLibraryKey,DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference,DepotDirectoryAttributes,DepotDirectoryResource,DepotDirectoryModel,String,K,F,R,A,RESOURCE,M> {

    protected DepotKey(URI uri, String id, DepotDirectoryKey directoryKey) {
        super(uri, id, directoryKey);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public DepotLibrary getLibrary() {
        return null;
    }

    public abstract static class Builder<K extends DepotKey<K,F,R,A,RESOURCE,M>,F extends Depot<K,F,R,A,RESOURCE,M>,R extends DepotReference<K,F,R,A,RESOURCE,M>,A extends DepotAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends DepotResource<K,F,R,A,RESOURCE,M>,M extends DepotModel<K,F,R,A,RESOURCE,M>> extends AddressedKey.Builder<DepotScheme, DepotLibraryKey,DepotLibrary, DepotPath,DepotCatalogKey,DepotCatalog,DepotDirectoryKey,DepotDirectory,DepotDirectoryReference,DepotDirectoryAttributes,DepotDirectoryResource,DepotDirectoryModel,String,K,F,R,A,RESOURCE,M> {

    }

}
