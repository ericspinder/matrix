/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.DirectoryLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.util.function.Function;

public class DnsDirectoryLibrarian extends DirectoryLibrarian<DnsScheme,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference,DnsCatalogLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian> {

    public DnsDirectoryLibrarian(Standard standard) {
        super(standard);
    }
}
