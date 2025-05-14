/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.file.directory.DirectoryKey;

import java.net.URI;

public class DnsDirectoryKey extends DirectoryKey<DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsPath> {
    protected DnsDirectoryKey(URI uri, DnsPath dnsPath) {
        super(uri, dnsPath);
    }


    public static class Builder extends DirectoryKey.Builder<DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsPath> {

        @Override
        protected DnsDirectoryKey newMatrixKey() {
            return new DnsDirectoryKey(this.uri,this.directoryPath);
        }
    }

}
