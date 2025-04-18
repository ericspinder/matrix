/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.LibraryKey;

import java.net.URI;

public class DnsLibraryKey extends LibraryKey<DnsScheme,DnsLibraryKey,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalogKey,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference, DnsCatalogLibrarian,DnsDirectoryLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian> {
    protected DnsLibraryKey(URI uri, DnsScheme scheme, Domain domain, int port, String separator) {
        super(uri, scheme, domain, port, separator);
    }
}
