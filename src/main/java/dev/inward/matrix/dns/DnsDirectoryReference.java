/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.dns;

import dev.inward.matrix.concept.file.directory.Directory;
import dev.inward.matrix.concept.file.directory.DirectoryLibrarian;
import dev.inward.matrix.concept.file.directory.DirectoryReference;

public class DnsDirectoryReference extends DirectoryReference<DnsScheme,DnsSchemeView,DnsSchemeModel,DnsAuthority,DnsAuthorityView,DnsAuthorityModel,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsDirectoryContext> {
    public DnsDirectoryReference(Directory referent, DirectoryLibrarian librarian) {
        super(referent, librarian);
    }
}
