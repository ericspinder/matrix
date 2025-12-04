/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.dns;

import dev.inward.matrix.concept.file.Factory;
import dev.inward.matrix.concept.file.Variant;
import dev.inward.matrix.concept.file.directory.DirectoryContext;

public class DnsDirectoryContext extends DirectoryContext<DnsScheme,DnsSchemeView,DnsSchemeModel,DnsAuthority,DnsAuthorityView,DnsAuthorityModel,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsDirectoryContext> {

    public DnsDirectoryContext(Variant variant, DnsDirectoryModel personality, Factory<DnsDirectory, DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsDirectoryContext> factory) {
        super(variant, personality, factory);
    }
}
