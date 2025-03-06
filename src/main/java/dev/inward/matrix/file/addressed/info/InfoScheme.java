/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Domain;
import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.file.addressed.AddressedScheme;

public class InfoScheme extends AddressedScheme<InfoScheme,InfoLibraryKey,InfoLibrary, InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference,InfoDirectoryAttributes,InfoDirectoryResource,InfoDirectoryModel> {
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
