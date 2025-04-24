/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;
import java.util.UUID;

public class MatterKey extends AddressedKey<LogScheme,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference,LogCatalogLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian,UUID,MatterKey,Matter,MatterView,MatterModel,MatterReference,MatterLibrarian> {


    protected MatterKey(URI uri, UUID uuid, LogDirectoryKey directoryKey) {
        super(uri, uuid, directoryKey);
    }

    public static class Builder extends AddressedKey.Builder<LogScheme,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference,LogCatalogLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian,UUID,MatterKey,Matter,MatterView,MatterModel,MatterReference,MatterLibrarian> {


        @Override
        protected MatterKey newMatrixKey() {
            return new MatterKey(this.uri, this.id,this.directoryKey);
        }
    }
}