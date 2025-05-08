/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.memory.bureau.Bureau;

import java.util.Map;

public class InfoLibrary extends Library<InfoScheme,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference,InfoLibraryLibrarian,InfoPath,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference,InfoCatalogLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference,InfoDirectoryLibrarian> {


    public InfoLibrary(InfoScheme scheme, Domain domain, int port, String separator) {
        super(scheme, domain, port, separator);
    }

    @Override
    protected Map<InfoCatalog, Bureau<?, ?, ?, ?, ?, ?, ?>[]> initCatalogs() {
        return null;
    }
}
