/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;
import java.util.UUID;

public class MatterKey extends AddressedKey<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference, LogCatalogLibrarian,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectoryLibrarian,MatterLibrarian,UUID,MatterKey,Matter,MatterView,MatterModel,MatterReference, MatterLibrarian> {


    protected MatterKey(URI uri, UUID uuid, LogDirectoryKey directoryKey) {
        super(uri, uuid, directoryKey);
    }

    public static class Builder {




    }
}