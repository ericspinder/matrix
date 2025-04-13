/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.container.catalog.Catalog;

public class DnsCatalog extends Catalog<DnsScheme,DnsLibraryKey,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibrarySteward,DnsPath,DnsCatalogKey,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference, DnsCatalogSteward,DnsDirectoryLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectorySteward> {
    public DnsCatalog(DnsCatalogKey catalogKey) {
        super(catalogKey);
    }

    @Override
    protected boolean init(DnsCatalogKey catalogKey) {
        return false;
    }

    @Override
    protected DnsDirectoryKey createDirectoryKey(DnsPath dnsPath) {
        return null;
    }
}
