/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.specification;

import dev.inward.matrix.file.addressed.depot.*;
import dev.inward.matrix.file.DirectoryKey;

import java.net.URI;

public class SpecificationKey extends DepotKey<SpecificationKey, Specification,SpecificationReference,SpecificationAttributes,SpecificationResource,SpecificationModel> {

    protected SpecificationKey(URI uri, DirectoryKey<DepotScheme, DepotLibrary, DepotPath> parentDirectory, String canonicalClassName) {
        super(uri, parentDirectory, canonicalClassName);
    }
}
