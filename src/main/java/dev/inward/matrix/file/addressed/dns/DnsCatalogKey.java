/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.container.catalog.CatalogKey;
import dev.inward.matrix.Range;
import dev.inward.matrix.engine.Zone;

import java.net.URI;

public class DnsCatalogKey extends CatalogKey<DnsScheme,DnsLibraryKey,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibrarySteward,DnsPath,DnsCatalogKey,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference, DnsCatalogSteward,DnsDirectoryLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectorySteward> {
    public DnsCatalogKey(URI uri, DnsLibrary dnsLibrary, Zone zone) {
        super(uri, dnsLibrary, new Range.AllPaths<>(),zone);
    }

    public static class Builder extends CatalogKey.Builder<DnsScheme,DnsLibraryKey,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibrarySteward,DnsPath,DnsCatalogKey,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference, DnsCatalogSteward,DnsDirectoryLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectorySteward> {

        @Override
        protected DnsCatalogKey newMatrixKey() {
            return new DnsCatalogKey(this.uri,this.library,this.zone);
        }
    }
}
