/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.control.catalog.CatalogKey;
import dev.inward.matrix.Range;
import dev.inward.matrix.engine.Zone;

import java.net.URI;

public class InfoCatalogKey extends CatalogKey<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibraryLibrarian,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogLibrarian,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectoryLibrarian> {
    protected InfoCatalogKey(URI uri, InfoLibrary library, Range<InfoPath> range, Zone zone) {
        super(uri, library, range, zone);
    }

    public static class Builder extends CatalogKey.Builder<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibraryLibrarian,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogLibrarian,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectoryLibrarian> {

        @Override
        protected InfoCatalogKey newMatrixKey() {
            return new InfoCatalogKey(this.uri,this.library,this.range,this.zone);
        }
    }
}
