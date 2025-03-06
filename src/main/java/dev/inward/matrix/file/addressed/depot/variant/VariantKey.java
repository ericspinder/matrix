/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.variant;

import dev.inward.matrix.file.addressed.depot.DepotKey;
import dev.inward.matrix.file.addressed.depot.DepotLibrary;
import dev.inward.matrix.file.addressed.depot.DepotPath;
import dev.inward.matrix.file.addressed.depot.DepotScheme;
import dev.inward.matrix.file.DirectoryKey;

import java.net.URI;

public class VariantKey extends DepotKey<VariantKey,Variant,VariantReference,VariantAttributes,VariantResource, VariantModel> {
    protected VariantKey(URI uri, DirectoryKey<DepotScheme, DepotLibrary, DepotPath> parentDirectory, String s) {
        super(uri, parentDirectory, s);
    }


}
