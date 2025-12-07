/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.fact.directory.DirectoryModel;

public class DepotDirectoryModel extends DirectoryModel<DepotDirectory,DepotDirectoryKey,DepotDirectoryView,DepotDirectoryModel, DepotDirectoryReference, DepotDirectoryLibrarian,DepotPath> {

    public DepotDirectoryModel(Aspect[] labeledAspects) {
        super(DepotDirectory.class, labeledAspects);
    }
}
