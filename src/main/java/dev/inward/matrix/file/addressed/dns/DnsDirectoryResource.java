/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.AddressedDirectoryResource;

import java.util.function.Function;

public class DnsDirectoryResource extends AddressedDirectoryResource<DnsScheme,DnsLibraryKey, DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel> {
    public DnsDirectoryResource(Function<DnsDirectoryReference, DnsDirectoryReference> graveDigger, DnsDirectoryModel model) {
        super(graveDigger, model);
    }
}
