/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.directory.DirectoryReference;

public class DnsDirectoryReference extends DirectoryReference<DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsPath> {
    public DnsDirectoryReference(DnsDirectory referent, DnsDirectoryLibrarian resource) {
        super(referent, resource);
    }
}
