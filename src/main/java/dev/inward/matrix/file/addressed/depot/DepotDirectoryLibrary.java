/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.directory.DirectoryLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class DepotDirectoryLibrary extends DirectoryLibrarian<DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,DepotPath> {


    public DepotDirectoryLibrary(Standard standard) {
        super(standard);
    }
}
