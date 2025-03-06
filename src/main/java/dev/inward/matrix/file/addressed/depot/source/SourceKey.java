/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.source;

import dev.inward.matrix.file.addressed.depot.DepotKey;
import dev.inward.matrix.file.addressed.depot.DepotLibrary;
import dev.inward.matrix.file.addressed.depot.DepotPath;
import dev.inward.matrix.file.addressed.depot.DepotScheme;
import dev.inward.matrix.file.DirectoryKey;

import java.net.URL;

public class SourceKey extends DepotKey<SourceKey,Source,SourceReference,SourceAttributes,SourceResource,SourceModel> {
    public SourceKey(URL url, DirectoryKey<DepotScheme, DepotLibrary, DepotPath> parentDirectory, String s) {
        super(url, parentDirectory, s);
    }
}
