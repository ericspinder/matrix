/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.control.library.LibraryView;

public class DnsLibraryView extends LibraryView<DnsScheme,DnsLibraryKey,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalogKey,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference, DnsCatalogLibrarian,DnsDirectoryLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian> {

    public DnsLibraryView(String name, DnsLibrary library, DnsLibraryModel libraryModel) {
        super(name, library, libraryModel);
    }
}
