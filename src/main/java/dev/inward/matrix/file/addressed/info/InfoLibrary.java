/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.container.library.Library;
import dev.inward.matrix.memory.bureau.Bureau;

import java.util.Map;

public class InfoLibrary extends Library<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibrarySteward,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogSteward,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectorySteward> {


    public InfoLibrary(InfoLibraryKey libraryKey) {
        super(libraryKey);
    }

    @Override
    protected Map<InfoCatalog, Bureau<?, ?, ?, ?>[]> initCatalogs() {
        return null;
    }

}
