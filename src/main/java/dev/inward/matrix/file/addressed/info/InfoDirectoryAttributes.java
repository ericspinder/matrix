/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.addressed.AddressedDirectoryAttributes;

import java.util.Map;

public class InfoDirectoryAttributes extends AddressedDirectoryAttributes<InfoScheme,InfoLibraryKey,InfoLibrary,InfoPath,InfoCatalogKey,InfoCatalog,InfoDirectoryKey,InfoDirectory,InfoDirectoryReference,InfoDirectoryAttributes,InfoDirectoryResource,InfoDirectoryModel> {
    public InfoDirectoryAttributes(Map<String, Model.InstanceValue> properties) {
        super(properties);
    }
}
