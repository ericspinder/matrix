/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.log;

import dev.inward.matrix.concept.file.addressed.AddressedLibrarian;
import dev.inward.matrix.concept.file.addressed.depot.specification.Specification;
import dev.inward.matrix.concept.file.addressed.depot.standard.Standard;

import java.util.UUID;

public class LogLibrarian extends AddressedLibrarian<Log,UUID, LogKey, LogView, LogModel, LogReference, LogLibrarian,LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel, LogDirectoryReference, LogDirectoryLibrarian,LogPath> {

    public LogLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
