/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.Range;
import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.engine.Zone;

import java.util.UUID;

public class DnsCatalog extends Catalog<DnsScheme,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference,DnsCatalogLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian> {


    public DnsCatalog(DnsLibrary library, Range<DnsPath> range, Zone zone) {
        super(library, range, zone);
    }

    @Override
    protected void init() {

    }

    @Override
    protected DnsDirectoryKey newDirectoryKey(String path) {
        return null;
    }
}
