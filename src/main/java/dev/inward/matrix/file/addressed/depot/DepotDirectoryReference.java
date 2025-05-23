/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.file.directory.DirectoryReference;

public class DepotDirectoryReference extends DirectoryReference<DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference, DepotDirectoryLibrarian,DepotPath> {
    public DepotDirectoryReference(DepotDirectory referent, DepotDirectoryLibrarian resource) {
        super(referent, resource);
    }
}
