/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.container.catalog.Catalog;

public class InfoCatalog extends Catalog<InfoScheme,InfoLibraryKey,InfoLibrary,InfoLibraryView,InfoLibraryModel,InfoLibraryReference, InfoLibrarySteward,InfoPath,InfoCatalogKey,InfoCatalog,InfoCatalogView,InfoCatalogModel,InfoCatalogReference, InfoCatalogSteward,InfoDirectoryLibrarian,InfoDirectoryKey,InfoDirectory,InfoDirectoryView,InfoDirectoryModel,InfoDirectoryReference, InfoDirectorySteward> {
    public InfoCatalog(InfoCatalogKey catalogKey) {
        super(catalogKey);
    }

    @Override
    protected boolean init(InfoCatalogKey catalogKey) {
        return false;
    }

    @Override
    protected InfoDirectoryKey createDirectoryKey(InfoPath infoPath) {
        return (new InfoDirectoryKey.Builder(this,infoPath)).buildKey();
    }
}
