/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.DirectoryKey;

import java.net.URI;

public class DnsDirectoryKey extends DirectoryKey<DnsScheme,DnsLibraryKey, DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel> {
    protected DnsDirectoryKey(URI uri, DnsCatalog catalog, DnsPath dnsPath) {
        super(uri, catalog, dnsPath);
    }


    public static class Builder extends DirectoryKey.Builder<DnsScheme,DnsLibraryKey, DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel> {

        @Override
        protected DnsDirectoryKey newFileKey() {
            return new DnsDirectoryKey(this.uri,this.catalog,this.directoryPath);
        }
    }

}
