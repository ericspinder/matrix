/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.log;

import dev.inward.matrix.concept.fact.addressed.AddressedReference;

import java.util.UUID;

public class LogReference extends AddressedReference<Log,UUID, LogKey, LogView, LogModel, LogReference, LogLibrarian,LogDirectory,LogDirectoryKey,LogDirectoryView,LogDirectoryModel, LogDirectoryReference, LogDirectoryLibrarian,LogPath> {
    public LogReference(Log addressed, LogLibrarian resource) {
        super(addressed, resource);
    }
}
