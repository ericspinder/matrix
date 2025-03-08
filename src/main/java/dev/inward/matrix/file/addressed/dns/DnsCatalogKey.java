/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.CatalogKey;
import dev.inward.matrix.Range;

import java.net.URI;

public class DnsCatalogKey extends CatalogKey<DnsScheme,DnsLibraryKey, DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel> {
    public DnsCatalogKey(URI uri,DnsLibrary dnsLibrary) {
        super(uri, dnsLibrary, new Range.AllPaths<>());
    }
}
