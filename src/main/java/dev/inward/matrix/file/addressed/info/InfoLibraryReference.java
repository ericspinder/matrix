/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.control.library.LibraryReference;

public class InfoLibraryReference extends LibraryReference<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian> {
    public InfoLibraryReference(InfoLibrary referent, InfoLibraryLibrarian libraryGestalt) {
        super(referent, libraryGestalt);
    }
}
