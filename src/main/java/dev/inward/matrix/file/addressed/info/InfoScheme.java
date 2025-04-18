/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

public class InfoScheme extends Scheme<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibraryLibrarian,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogLibrarian,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectoryLibrarian> {
    protected InfoScheme(Terrene terrene) {
        super(terrene, MatrixURLStreamHandlerProvider.Protocol.INFO);
    }

    @Override
    public int compareTo(InfoScheme o) {
        return 0;
    }

    @Override
    protected InfoLibraryKey makeLibraryKey(InfoScheme scheme, Domain domain, int port, String separator) {
        return null;
    }

    @Override
    protected InfoLibrary buildLibrary(InfoLibraryKey libraryKey) {
        return null;
    }
}
