/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Domain;
import dev.inward.matrix.file.addressed.AddressedLibraryKey;

import java.net.URI;

public class InfoLibraryKey extends AddressedLibraryKey<InfoScheme,InfoLibraryKey,InfoLibrary, InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference,InfoDirectoryAttributes,InfoDirectoryResource,InfoDirectoryModel> {
    protected InfoLibraryKey(URI uri, InfoScheme scheme, Domain domain, int port, String separator) {
        super(uri, scheme, domain, port, separator);
    }
}
